package org.pmg.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.ldap.core.*;
import org.springframework.ldap.query.LdapQuery;
import org.springframework.ldap.support.LdapNameBuilder;
import org.springframework.stereotype.Component;

import javax.naming.Name;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;

import static org.springframework.ldap.query.LdapQueryBuilder.query;

/**
 *
 CN (Common Name) : KilDong Hong, SaRang Lee 와 같은 일반적인 이름들
 SN (SirName) : 우리나라 성에 해당한다. Lee, Hong ..
 OU (Organiztion Unit) : 그룹에 해당
 DC (Domain Component) : 도메인에 대한 요소 ex ) tech.example.com dc 는 example.com 혹은 tech.example.com 모두 해당
 DN (Distinguished Name) : 위의 엔트리 및 기타 여러가지 엔트리들이 모여 특정한 한 사용자(혹은 물체)를 구분할 수 있는 고유의 이름.
 */
@Component
public class LdapClient {

    @Autowired
    private Environment env;

    @Autowired
    private ContextSource contextSource;

    @Autowired
    private LdapTemplate ldapTemplate;

    private static class PersonAttributesMapper implements AttributesMapper<Person> {
        @Override
        public Person mapFromAttributes(Attributes attrs) throws NamingException {
            Person person = new Person();
            person.setCn((String)attrs.get("cn").get());
            person.setSn((String)attrs.get("sn").get());
            person.setUid((String)attrs.get("uid").get());
            return person;
        }
    }

    public void authenticate(final String username, final String password) {
        contextSource.getContext("cn=" + username + ",ou=users," + env.getRequiredProperty("ldap.partitionSuffix"), password);
    }

    public List<Person> search(final String username) {
        return ldapTemplate.search(
                query().base("ou=space cadets,dc=springframework,dc=org").where("objectclass").is("person"),
                new PersonAttributesMapper());
    }
    public Person findPerson(String dn) {
        return ldapTemplate.lookup(dn, new PersonAttributesMapper());
    }

    /**
     *
     * @param lastName sn
     * @return
     */
    public List<String> getPersonNamesByLastName(String lastName) {

        LdapQuery query = query()
                .base("dc=springframework,dc=org")
                .attributes("cn", "sn") // 가져 올 속성
                .where("objectclass").is("person")
                .and("sn").is(lastName);

        return ldapTemplate.search(query,
                // attributes에 정의된 속성만 가져올 수 있고 나머지는 null
                (AttributesMapper<String>) attrs -> (String) attrs.get("cn").get());
    }
    public void create(final String username, final String password) {
        Name dn = LdapNameBuilder
                .newInstance()
                .add("ou", "users")
                .add("cn", username)
                .build();
        DirContextAdapter context = new DirContextAdapter(dn);

        context.setAttributeValues("objectclass", new String[] { "top", "person", "organizationalPerson", "inetOrgPerson" });
        context.setAttributeValue("cn", username);
        context.setAttributeValue("sn", username);
        context.setAttributeValue("userPassword", digestSHA(password));

        ldapTemplate.bind(context);
    }

    public void modify(final String username, final String password) {
        Name dn = LdapNameBuilder
                .newInstance()
                .add("ou", "users")
                .add("cn", username)
                .build();
        DirContextOperations context = ldapTemplate.lookupContext(dn);

        context.setAttributeValues("objectclass", new String[] { "top", "person", "organizationalPerson", "inetOrgPerson" });
        context.setAttributeValue("cn", username);
        context.setAttributeValue("sn", username);
        context.setAttributeValue("userPassword", digestSHA(password));

        ldapTemplate.modifyAttributes(context);
    }

    private String digestSHA(final String password) {
        String base64;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA");
            digest.update(password.getBytes());
            base64 = Base64
                    .getEncoder()
                    .encodeToString(digest.digest());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return "{SHA}" + base64;
    }
}