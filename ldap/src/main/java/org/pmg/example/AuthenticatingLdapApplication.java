package org.pmg.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
public class AuthenticatingLdapApplication {

    @Autowired
    LdapClient ldapClient;

    public static void main(String[] args) {
        SpringApplication.run(AuthenticatingLdapApplication.class, args);
    }

    @PostConstruct
    public void test() {
        List<Person> search = ldapClient.search("joe");
        System.err.println(search.toString());
        Person person = ldapClient.findPerson("uid=space cadet,ou=space cadets,dc=springframework,dc=org");
        System.err.println(person);
        List<String> cadet = ldapClient.getPersonNamesByLastName("Cadet");
        System.err.println(cadet.toString());

    }

}
