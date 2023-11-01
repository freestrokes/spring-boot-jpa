package com.freestrokes.repository;

import com.freestrokes.domain.BoardEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, String> {

    Page<BoardEntity> findAll(Pageable pageable);

    // TODO: JPQL 사용 예시
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
    @Query("SELECT board FROM BoardEntity board JOIN FETCH board.boardComments")
    List<BoardEntity> findAllFetchJoin();

}
