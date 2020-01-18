package com.github.mugoonpark.onetoone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * 연관 관계의 주인
 */
@Entity
public class O2OEmployee {
    @Id @GeneratedValue
    private int id;

    @OneToOne
    private O2OLocker locker;

}
