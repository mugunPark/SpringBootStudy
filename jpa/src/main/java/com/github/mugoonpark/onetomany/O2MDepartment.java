package com.github.mugoonpark.onetomany;

import javax.persistence.*;
import java.util.List;
/**
 * 연관 관계의 주인
 */
@Entity
public class O2MDepartment {

    @Id @GeneratedValue
    private int id;

    @OneToMany
    @JoinColumn(name = "DEPT_ID", referencedColumnName = "id")
    private List<O2MEmployee> employees;
}
