package org.pmg.example;

public class Person {
    private String cn;
    private String sn;
    private String uid;

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Person{" +
                "cn='" + cn + '\'' +
                ", sn='" + sn + '\'' +
                ", uid='" + uid + '\'' +
                '}';
    }
}
