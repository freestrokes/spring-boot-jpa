package com.freestrokes.controller;

import com.freestrokes.aop.LogExecutionTime;
import com.freestrokes.config.ApplicationProperties;
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
public class HealthController {

    /**
     * 게시글 목록 조회
     *
     * @return
     * @throws Exception
     */
    @GetMapping(path = "/health-check", produces = "application/json")
    @LogExecutionTime
    public ResponseEntity<?> getBoards() throws Exception {
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }

}
