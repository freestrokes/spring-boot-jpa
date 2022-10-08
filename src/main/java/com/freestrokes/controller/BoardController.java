package com.freestrokes.controller;

import com.freestrokes.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardService boardService;

    @GetMapping(path = "/api/v1/boards", produces = "application/json")
    public List getBoardList() throws Exception {

        List boardList = boardService.getBoardList();

        return boardList;
    }

}
