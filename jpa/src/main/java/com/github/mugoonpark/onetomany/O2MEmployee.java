package com.github.mugoonpark.onetomany;

import javax.persistence.*;

@Entity
public class O2MEmployee {
    @Id @GeneratedValue
    private int id;

    /**
     * 양 방향 일 때만
     */
    @ManyToOne
    @JoinColumn(name="id", insertable=false, updatable=false)
    private O2MDepartment dept;
}
