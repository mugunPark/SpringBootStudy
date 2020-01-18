package com.github.mugoonpark.mappedsuperclass;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <code>@MappedSuperclass</code>을 지정한 클래스는 엔티티가 아니므로 영속성 컨텍스트에서 조회 할 수 없다.
 * 실제 new를 사용하여 생성 할 필요가 없으므로 추상클래스로 만드는 것이 좋다.
 *
 * 필드에 <code>@Column(name=””)</code>을 사용하여 별도로 매핑 정보를 주지 않으면, 네이밍 규칙에 따라 컬럼과 자동으로 매핑한다.
 * 상속받은 엔티티의 필드명과 데이틀의 컬럼 명이 다른경우, <code>@AttributeOverride</code> 를 사용하여 컬럼명을 직접 지정할 수 있다.
 */
public class MappedSuperclassEx {
    @MappedSuperclass
    public static abstract class MappedSuperclassBaseInfo {
        @Id
        @GeneratedValue
        private int id;

        private String name;

        @Temporal(TemporalType.TIMESTAMP)
        private Date updatedDate;
        private int updatedUserId;

        @Temporal(TemporalType.TIMESTAMP)
        private Date createdDate;
        private int createdUserId;
    }

    @Entity
    public static  class MappedSuperclassDepartment extends MappedSuperclassBaseInfo {
        // 공통 속성 상속 받음
    }
    @Entity
    public static class MappedSuperclassEmployee extends MappedSuperclassBaseInfo {
        // 공통 속성 상속 받음

        // 나머지 속성만 추가
        private BigDecimal salary;

        @ManyToOne
        @JoinColumn(name="DEPARTMENT_ID")
        private MappedSuperclassDepartment dept;
    }
    @Entity
    @AttributeOverrides({
            @AttributeOverride(name="id",   column=@Column(name="MEETING_ID")),
            @AttributeOverride(name="name", column=@Column(name="MEETING_NAME"))
    })
    public static class MappedSuperclassMeeting extends MappedSuperclassBaseInfo {
    }
}
