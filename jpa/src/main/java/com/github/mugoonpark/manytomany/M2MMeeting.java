package com.github.mugoonpark.manytomany;

import javax.persistence.*;
import java.util.List;

@Entity
public class M2MMeeting {
    @Id @GeneratedValue
    private int id;

    /**
     * 양 방향 일 때만....
     * mappedBy = M2MEmployee 엔티티를 연관관계 주인으로 지정(M2MEmployee 클래스의 변수 이름)
     */
    @ManyToMany(mappedBy="meetings")
    private List<M2MEmployee> employees;
}
