package com.freestrokes.controller;

import com.freestrokes.dto.BoardDto;
import com.freestrokes.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardService boardService;

    @GetMapping(path = "/api/v1/boards", produces = "application/json")
    public ResponseEntity<List<BoardDto.ResponseDto>> getBoards() throws Exception {
        List<BoardDto.ResponseDto> result = boardService.getBoards();
        return new ResponseEntity<List<BoardDto.ResponseDto>>(result, HttpStatus.OK);
    }

    @PostMapping(path = "/api/v1/boards", produces = "application/json")
    public ResponseEntity<BoardDto.ResponseDto> postBoard(@RequestBody BoardDto.RequestDto boardDto) throws Exception {
        BoardDto.ResponseDto result = boardService.postBoard(boardDto);
        return new ResponseEntity<BoardDto.ResponseDto>(result, HttpStatus.OK);
    }

    @PutMapping(path = "/api/v1/boards/{id}", produces = "application/json")
    public ResponseEntity<BoardDto.ResponseDto> putBoard(@PathVariable Long id, @RequestBody BoardDto.RequestDto boardDto) throws Exception {
        BoardDto.ResponseDto result = boardService.putBoard(id, boardDto);
        return new ResponseEntity<BoardDto.ResponseDto>(result, HttpStatus.OK);
    }

    @DeleteMapping(path = "/api/v1/boards/{id}", produces = "application/json")
    public ResponseEntity<?> deleteBoard(@PathVariable Long id) throws Exception {
        boardService.deleteBoard(id);
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }

}
