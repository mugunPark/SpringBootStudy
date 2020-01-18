package com.github.mugoonpark.manytoone;

import javax.persistence.*;

/**
 * 연관 관계의 주인
 */
@Entity
public class M2OEmployee {
    @Id @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "DEPT_ID", referencedColumnName = "id")
    private M2ODepartment dept;
}
