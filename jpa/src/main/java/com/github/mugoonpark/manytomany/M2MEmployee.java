package com.github.mugoonpark.manytomany;

import javax.persistence.*;
import java.util.List;

/**
 * 연관 관계의 주인
 */
@Entity
public class M2MEmployee {
    @Id @GeneratedValue
    private int id;

    /**
     * {@code @JoinTable를 사용하지 않으면 기본으로 두 테입블의 PK를 이용하여 테이블이 생성됨.}
     */
    @ManyToMany
    @JoinTable(name="EMPLOYEE_MEETING",
            joinColumns=@JoinColumn(name="id"),
            inverseJoinColumns=@JoinColumn(name = "meeting_id", referencedColumnName="id"))
    private List<M2MMeeting> meetings;
}
