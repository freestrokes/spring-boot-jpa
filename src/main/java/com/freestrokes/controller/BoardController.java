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
@RequestMapping("/api/v1")
public class BoardController {

    private final BoardService boardService;

    @GetMapping(path = "/boards", produces = "application/json")
    public ResponseEntity<List<BoardDto.ResponseDto>> getBoards() throws Exception {
        List<BoardDto.ResponseDto> result = boardService.getBoards();
        return new ResponseEntity<List<BoardDto.ResponseDto>>(result, HttpStatus.OK);
    }

    @PostMapping(path = "/boards", produces = "application/json")
    public ResponseEntity<BoardDto.ResponseDto> postBoard(@RequestBody BoardDto.RequestDto boardRequestDto) throws Exception {
        BoardDto.ResponseDto result = boardService.postBoard(boardRequestDto);
        return new ResponseEntity<BoardDto.ResponseDto>(result, HttpStatus.OK);
    }

    @PutMapping(path = "/boards/{id}", produces = "application/json")
    public ResponseEntity<BoardDto.ResponseDto> putBoard(@PathVariable Long id, @RequestBody BoardDto.RequestDto boardRequestDto) throws Exception {
        BoardDto.ResponseDto result = boardService.putBoard(id, boardRequestDto);
        return new ResponseEntity<BoardDto.ResponseDto>(result, HttpStatus.OK);
    }

    @DeleteMapping(path = "/boards/{id}", produces = "application/json")
    public ResponseEntity<?> deleteBoard(@PathVariable Long id) throws Exception {
        boardService.deleteBoard(id);
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }

}
