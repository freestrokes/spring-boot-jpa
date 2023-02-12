package com.freestrokes.repository;

import com.freestrokes.domain.BoardComment;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BoardCommentRepository extends JpaRepository<BoardComment, String> {

    // TODO: CASE2) repository 메서드에 @EntityGraph 사용하여 연관 객체 조회
//    @EntityGraph(
//        attributePaths = {"board"},
//        type = EntityGraph.EntityGraphType.FETCH
//    )
//    Optional<BoardComment> findByBoardCommentId(String boardCommentId);

}
