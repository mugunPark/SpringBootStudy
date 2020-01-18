package com.github.mugoonpark.inheritance;

import javax.persistence.*;

/**
 * 조인 전략(Joined Strategy): 각 테이블로 분할
 * 장점: 정규화된 테이블로 유지 가능
 * 단점: 조인이 많아져서 쿼리가 복잡 해지고 느려짐
 */
public class JoinedInheritance {
    @Entity
    @Inheritance(strategy= InheritanceType.JOINED)
    @DiscriminatorColumn(name="DTYPE")
    public static abstract class JoinedItem {
        @Id @GeneratedValue
        private int idx;

        private String abc;
    }

    @Entity
    @DiscriminatorValue("A")
    public static class JoinedAlbum extends JoinedItem {
    }

    @Entity
    @DiscriminatorValue("B")
    public static class JoinedBook extends JoinedItem {
    }

    @Entity
    @DiscriminatorValue("D")
    public static class JoinedDVD extends JoinedItem {
    }

}

