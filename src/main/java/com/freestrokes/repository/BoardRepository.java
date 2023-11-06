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

    Page<BoardEntity> findAll(Pageable pageable);

    // TODO: 카테시안 곱 (Cartesian Product)
    // join fetch와 entityGraph 사용시 카테시안 곱이 발생 함
    // 카테시안 곱은 연관관계의 엔티티 사이에 유효한 join 조건을 사용하지 않았을 때,
    // 해당 엔티티의 모든 데이터 행 개수를 곱한 결과가 반환되는 것.
    // 카테시안 곱은 명확한 Join 규칙이 주어지지 않았을 때 발생.
    // join 이후 on 절이 주어지지 않으면 db는 두 엔티티의 결합 조건이 없기 때문에 M * N으로 모든 경우의 수를 조회하여 반환.
    // Set 또는 쿼리에 distinct 사용하여 해결. (순서 보장이 필요한 경우엔 LinkedHashSet 사용)

    // TODO: JPQL left join fetch
    // 아래와 같이 추가 컬렉션을 재귀적으로 가져오는 경우에 사용.
//    @Query(
//        "SELECT provisioning " +
//            "FROM ProvisioningEntity provisioning " +
//            "LEFT JOIN FETCH provisioning.library library " +
//            "LEFT JOIN FETCH library.icon libraryIcon " +
//            "WHERE provisioning.projectId = :projectId"
//    )

    // TODO: JPQL 사용시 cannot resolve symbol 에러가 발생하는 경우
    // 도메인 클래스에서 @Entity(name = "board_comment") 이와 같이 사용하며 안 됨.
    // @Entity만 작성해서 사용하고 실제 테이블명은 @Table(name = "board_comment") 이와 같이 사용해야 함.
    @Query("SELECT DISTINCT board FROM BoardEntity board JOIN FETCH board.boardComments")
    List<BoardEntity> findAllByFetchJoin();

    // TODO: EntityGraph 사용 예시
    // attributePaths에는 필드명을 작성해줘야 함 (엔티티명 아님)
    // EntityGraphType.LOAD
    // EntityGraph에 명시한 attribute는 EAGER로 패치, 나머지 attribute는 명시한 FetchType 또는 디폴트 FetchType으로 패치
    // @OneToMany는 LAZY, @ManyToOne은 EAGER 디폴트
    // EntityGraphType.FETCH
    // EntityGraph에 명시한 attribute는 EAGER로 패치, 나머지 attribute는 LAZY로 패치
    @EntityGraph(
        attributePaths = {"boardComments"},
        type = EntityGraph.EntityGraphType.LOAD
    )
    @Query("SELECT board FROM BoardEntity board")
    List<BoardEntity> findAllByEntityGraph();

}
