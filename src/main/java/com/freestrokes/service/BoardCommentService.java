package com.freestrokes.service;

import com.freestrokes.domain.Board;
import com.freestrokes.domain.BoardComment;
import com.freestrokes.dto.BoardCommentDto;
import com.freestrokes.repository.BoardCommentRepository;
import com.freestrokes.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BoardCommentService {

    private final BoardRepository boardRepository;
    private final BoardCommentRepository boardCommentRepository;

    /**
     * 게시글 댓글 등록
     *
     * @param boardCommentRequestDto
     * @return
     * @throws Exception
     */
    @Transactional
    public BoardCommentDto.ResponseDto postBoardComment(BoardCommentDto.RequestDto boardCommentRequestDto) throws Exception {

        // 게시글 조회
        Board findBoard = boardRepository.findById(boardCommentRequestDto.getBoardId()).orElseThrow(NoSuchElementException::new);

        // 게시글 댓글 생성
        BoardComment boardComment = BoardComment.builder()
            .board(findBoard)
            .content(boardCommentRequestDto.getContent())
            .author(boardCommentRequestDto.getAuthor())
            .build();

        // 게시글 댓글 등록
        boardCommentRepository.save(boardComment);

        return BoardCommentDto.ResponseDto.builder()
            .boardCommentId(boardComment.getBoardCommentId())
            .board(boardComment.getBoard())
            .content(boardComment.getContent())
            .author(boardComment.getAuthor())
            .build();

    }

    /**
     * 게시글 댓글 수정
     *
     * @param boardCommentId
     * @param boardCommentRequestDto
     * @return
     * @throws Exception
     */
    @Transactional
    public BoardCommentDto.ResponseDto putBoardComment(String boardCommentId, BoardCommentDto.RequestDto boardCommentRequestDto) throws Exception {

        // 게시글 댓글 조회
        BoardComment findBoardComment = boardCommentRepository.findById(boardCommentId).orElseThrow(NoSuchElementException::new);

        // 게시글 댓글 저장
        findBoardComment.updateBoardComment(
            boardCommentRequestDto.getContent(),
            boardCommentRequestDto.getAuthor()
        );

        return BoardCommentDto.ResponseDto.builder()
            .boardCommentId(findBoardComment.getBoardCommentId())
            .board(findBoardComment.getBoard())
            .content(findBoardComment.getContent())
            .author(findBoardComment.getAuthor())
            .build();

    }

    /**
     * 게시글 댓글 삭제
     *
     * @param boardCommentId
     * @throws Exception
     */
    @Transactional
    public void deleteBoardComment(String boardCommentId) throws Exception {
        // 게시글 댓글 삭제
        boardCommentRepository.deleteById(boardCommentId);
    }

}
