package com.freestrokes.repository;

import com.freestrokes.domain.BoardEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, String> {

    // NOTE: Fetch Join 및 EntityGraph 사용 시 발생하는 카테시안 곱 (Cartesian Product)
    // Fetch Join 및 EntityGraph 사용시 카테시안 곱이 발생 함
    // 카테시안 곱은 연관관계의 엔티티 사이에 유효한 join 조건을 사용하지 않았을 때, 해당 엔티티의 모든 데이터 행 개수를 곱한 결과가 반환되는 것.
    // Join 규칙이 주어지지 않으면 결합 조건이 없기 때문에, db는 M * N으로 모든 경우의 수를 조회하여 반환.
    // 중복 문제가 발생하기 때문에 Set 또는 쿼리에 distinct 사용하여 해결. (순서 보장이 필요한 경우엔 LinkedHashSet 사용)

    // NOTE: Fetch Join과 EntityGraph 차이
    // Fetch Join은 Inner Join을 사용하고 EntityGraph는 OuterJoin을 사용하는 차이가 있음.

    // NOTE: JPQL left join fetch
    // left join fetch는 아래와 같이 추가적인 컬렉션을 재귀적으로 가져오는 경우에 사용.
//    @Query(
//        "SELECT provisioning " +
//            "FROM ProvisioningEntity provisioning " +
//            "LEFT JOIN FETCH provisioning.library library " +
//            "LEFT JOIN FETCH library.icon libraryIcon " +
//            "WHERE provisioning.projectId = :projectId"
//    )

    // NOTE: JPQL 사용시 cannot resolve symbol 에러가 발생하는 경우
    // 도메인 클래스에서 @Entity(name = "board_comment") 이와 같이 사용하며 안 됨.
    // @Entity 애너테이션을 속성없이 작성해서 사용하고 실제 테이블명은 @Table(name = "board_comment") 이와 같이 사용해야 함.
    @Query("SELECT DISTINCT board FROM BoardEntity board JOIN FETCH board.boardComments")
    List<BoardEntity> findAllByFetchJoin();

    // NOTE: EntityGraph 사용 예시
    // attributePaths에는 필드명을 작성해줘야 함 (엔티티명 아님)
    // EntityGraph는 Outer Join을 사용.

    // 1. EntityGraphType.LOAD
    // EntityGraph에 명시한 attribute는 EAGER로 패치, 나머지 attribute는 명시한 FetchType 또는 디폴트 FetchType으로 패치
    // @OneToMany는 LAZY, @ManyToOne은 EAGER 디폴트

    // 2. EntityGraphType.FETCH
    // EntityGraph에 명시한 attribute는 EAGER로 패치, 나머지 attribute는 LAZY로 패치
    @EntityGraph(
        attributePaths = {"boardComments"},
        type = EntityGraph.EntityGraphType.LOAD
    )
    @Query("SELECT DISTINCT board FROM BoardEntity board")
    List<BoardEntity> findAllByEntityGraph();

    // NOTE: Pageable 이용한 기본적인 Pagination
    Page<BoardEntity> findAll(Pageable pageable);

    // NOTE: 일대다(1:N) 연관관계에서 Fetch Join을 이용한 Pagination
    // 일대다(1:N) 연관관계에 대해 Fetch Join을 이용하여 페이징을 하면 데이터 정합성에 문제가 발생할 수 있음.
    // 정합성 문제는 데이터의 값들이 서로 일치하지 않는 것.
    // 일대다(1:N) 연관관계의 테이블을 조인하면 데이터의 개수가 달라져 정합성에 문제가 발생 할 수 있음.
    // 따라서 다대일(N:1) 연관관계에서 Fetch Join을 이용한 페이징 처리를 해주는 것이 권장 됨.
    // Hibernate의 BatchSize를 설정하거나 @EntityGraph 애너테이션을 이용하여 페이징을 처리.

    // OneToOne, ManyToOne 애너테이션을 통해 형성된 관계인 경우,
    // 테이블 조인에 따라 데이터 수가 변경되지 않으므로 페이징 처리 가능.

    // OneToMany, ManyToMany 애너테이션을 통해 형성된 관계인 경우,
    // 테이블 조인에 따라 데이터가 수가 변경되어 페이징 처리와 페치 조인 모두 불가능.

    // NOTE: EntityGraph 이용한 Pagination
    @EntityGraph(
        attributePaths = {"boardComments"},
        type = EntityGraph.EntityGraphType.LOAD
    )
    @Query("SELECT DISTINCT board FROM BoardEntity board")
    Page<BoardEntity> findAllByEntityGraphWithPaging(Pageable pageable);

}
