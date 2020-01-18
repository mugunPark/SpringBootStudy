package com.github.mugoonpark.onetoone;

import javax.persistence.*;

@Entity
public class O2OLocker {
    @Id @GeneratedValue
    private int id;

    /**
     * 양 방향 일 때만....
     * mappedBy = O2OEmployee 엔티티를 연관관계 주인으로 지정(O2OEmployee 클래스의 변수 이름)
     */
    @OneToOne(mappedBy = "locker")
    private O2OEmployee employee;
}
