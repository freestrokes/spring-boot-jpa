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

    // TODO: 카테시안 곱
    // join fetch와 entityGraph 사용시 카테시안 곱이 발생 함
    // 이를 해결하기 위해 Set 도는 쿼리에 distinct 사용

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
