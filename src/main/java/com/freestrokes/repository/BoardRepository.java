package com.freestrokes.repository;

import com.freestrokes.domain.Board;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, String> {

    @EntityGraph(attributePaths = {"boardComments"}, type = EntityGraph.EntityGraphType.FETCH)
    List<Board> findAll();

}
