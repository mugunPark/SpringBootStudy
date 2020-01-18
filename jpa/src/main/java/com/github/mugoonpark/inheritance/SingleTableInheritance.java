package com.github.mugoonpark.inheritance;

import javax.persistence.*;

/**
 * 단일 테이블 전략(Single-Table Strategy): 모든 컬럼을 한 테이블로 합침. 구분 컬럼으로 구분.
 * 장점: 조인이 없어 쿼리가 단순하고 빠름.
 * 단점: 모든 컬럼이 null을 허용해야됨. 테이블에 컬럼이 너무 많아짐.
 */
public class SingleTableInheritance {
    @Entity
    @Inheritance(strategy= InheritanceType.SINGLE_TABLE)
    @DiscriminatorColumn(name="DTYPE")
    public static abstract class SingleTableItem {
        @Id
        @GeneratedValue
        private int idx;

        private String abc;
    }

    @Entity
    @DiscriminatorValue("A")
    public static class SingleTableAlbum extends SingleTableItem {
        private String album;
    }

    @Entity
    @DiscriminatorValue("B")
    public static class SingleTableBook extends SingleTableItem {
        private String book;
    }

    @Entity
    @DiscriminatorValue("D")
    public static class SingleTableDVD extends SingleTableItem {
        private String dvd;
    }
}
