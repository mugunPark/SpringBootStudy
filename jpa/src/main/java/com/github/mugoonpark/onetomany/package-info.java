/**
 * <b>일대다(One To Many)</b>
 * <ul>
 *     <li>일대다 관계는 항상 다대일 관계의 반대 방향이다.</li>
 *     <li>참조 대상이 다 건이므로 Collection, List, Set, Map 자료구조를 사용한다.</li>
 *     <li></li>
 * </ul>
 * <b>단방향</b>
 * <ul>
 *     <li>일대다 단방향 관계는 다대일 양방향 관계로 바꿔서 사용하는 것이 좋다.</li>
 *     <li>Department에서 Employee 쪽에 있는 외래키를 수정해야 되기때문에 SQL이 더 많이 실행된다.</li>
 *     <li>Department에 Employee 추가하는 경우 INSERT 실행 후 외래키 UPDATE 하는 SQL이 한번 더 실행된다.</li>
 * </ul>
 * <b>양방향</b>
 * <ul>
 *     <li>일대다(1:N) 관계의 양방향은 다대일(N:1) 관계의 양방향과 같은 의미이다.</li>
 *     <li>단, 일(1) 을 연관관계 주인으로 설정하는 방법은 존재하지 않는다.
 *     연관관계 주인은 외래키가 있는 곳 인데, 이는 항상 다(N) 쪽에 존재한다.
 *     </li>
 *     <li>연관관계 주인 설정은 할 수 없지만, 의미상 표현은 다음과 같이 하면된다.</li>
 * </ul>
 */
package com.github.mugoonpark.onetomany;

