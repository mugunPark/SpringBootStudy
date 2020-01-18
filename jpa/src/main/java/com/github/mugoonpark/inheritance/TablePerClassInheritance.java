package com.github.mugoonpark.inheritance;

import javax.persistence.*;

/**
 * 구현 클래스 별 테이블 전략(Table per Concrete Class Strategy): 엔티티마다 테이블을 별도로 만듬.
 * 장점: 타입별로 처리할때 효과적. not null 제약조건 사용 가능.
 * 단점: 모든 ITEM을 한번에 조회 할 때 UNION을 사용해야 되서 느리다.
 */
public class TablePerClassInheritance {
    @Entity
    @Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
    public static abstract class TablePerClassItem {
        @Id @GeneratedValue
        private int idx;

        private String abc;
    }

    @Entity
    @DiscriminatorValue("A")
    public static class TablePerClassAlbum extends TablePerClassItem {
        private String album;
    }

    @Entity
    @DiscriminatorValue("B")
    public static class TablePerClassBook extends TablePerClassItem {
        private String book;
    }

    @Entity
    @DiscriminatorValue("D")
    public static class TablePerClassDVD extends TablePerClassItem {
        private String dvd;
    }

}

