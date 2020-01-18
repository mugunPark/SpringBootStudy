package com.github.mugoonpark.common;


import lombok.Setter;

import javax.persistence.*;


@Entity
@Setter
public class DefaultCustomer {

    @Id
    private String id;

    private String firstName;

    private String lastName;

    @Enumerated(EnumType.STRING)
    private DefaultCustomerType type;  // public enum CustomerType { GOLD, SILVER, BASIC }

    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date createdDate;

    private String description;

    @Transient
    private String tempVal;

}
