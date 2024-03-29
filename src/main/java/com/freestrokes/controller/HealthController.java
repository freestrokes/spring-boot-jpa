package com.freestrokes.controller;

import com.freestrokes.aop.LogExecutionTime;
import com.freestrokes.constants.PathConstants;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// NOTE: @RequestMapping
// 해당 컨트롤러 하위 전체 메서드에 공통 path 설정이 필요한 경우 class 상단에 애너테이션 사용.
// @RequestMapping("/api/v1")
@Tag(name = "Health")
@RestController
@RequiredArgsConstructor
public class HealthController {

    /**
     * 게시글 목록 조회
     *
     * @return
     * @throws Exception
     */
    @GetMapping(path = PathConstants.HEALTH_CHECK, produces = "application/json")
    @LogExecutionTime
    public ResponseEntity<?> getBoards() throws Exception {
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }

}
