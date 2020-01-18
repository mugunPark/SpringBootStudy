package com.github.mugoonpark.manytoone;

import javax.persistence.*;
import java.util.List;

@Entity
public class M2ODepartment {

    @Id @GeneratedValue
    private int id;

    /**
     * 양 방향 일 때만....
     * mappedBy = M2OEmployee 엔티티를 연관관계 주인으로 지정(M2OEmployee 클래스의 변수 이름)
     */
    @OneToMany(mappedBy = "dept")
    private List<M2OEmployee> employees;
}
