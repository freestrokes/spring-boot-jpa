package com.freestrokes.repository;

import com.freestrokes.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, String> {

    Page<Board> findAll(Pageable pageable);

//    @Query(
//        "SELECT provisioning " +
//            "FROM ProvisioningEntity provisioning " +
//            "LEFT JOIN FETCH provisioning.library library " +
//            "LEFT JOIN FETCH library.icon libraryIcon " +
//            "WHERE provisioning.projectId = :projectId"
//    )

    // TODO: Board 엔티티 인식 안되는 문제 확인 필요
//    @Query("SELECT boardEntity FROM Board boardEntity JOIN FETCH boardEntity.boardComments")
    List<Board> findAllFetchJoin();

}
