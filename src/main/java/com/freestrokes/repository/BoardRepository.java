package com.freestrokes.repository;

import com.freestrokes.domain.Board;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, String> {

    // TODO: @EntityGraph
    // 즉시로딩(EAGER) 방식으로 매핑된 연관관계의 객체를 조회
    // left outer join으로 읽어오기 때문에 LazyInitializtionException 해결 가능
    // but, 부모 엔티티를 중복 조회하여 권장되지 않음. (이 경우에 대해 distinct 설정 가능)
//    @EntityGraph(attributePaths = {"boardComments"}, type = EntityGraph.EntityGraphType.FETCH)
    List<Board> findAll();

}
