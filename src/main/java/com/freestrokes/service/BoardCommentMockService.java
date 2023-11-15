package com.freestrokes.service;

import com.freestrokes.domain.BoardEntity;
import com.freestrokes.domain.BoardCommentEntity;
import com.freestrokes.dto.BoardCommentDto;
import com.freestrokes.repository.BoardCommentRepository;
import com.freestrokes.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@Profile("dev")
@RequiredArgsConstructor
public class BoardCommentMockService implements BoardCommentRequestService {

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
    public BoardCommentDto.ResponseDto postBoardComment(BoardCommentDto.RequestDto boardCommentRequestDto) {

        // 게시글 조회
        BoardEntity findBoardEntity = boardRepository.findById(boardCommentRequestDto.getBoardId()).orElseThrow(NoSuchElementException::new);

        // 게시글 댓글 생성
        BoardCommentEntity boardCommentEntity = BoardCommentEntity.builder()
            .board(findBoardEntity)
            .content(boardCommentRequestDto.getContent())
            .author(boardCommentRequestDto.getAuthor())
            .build();

        // 게시글 댓글 등록
        boardCommentRepository.save(boardCommentEntity);

        return BoardCommentDto.ResponseDto.builder()
            .boardCommentId(boardCommentEntity.getBoardCommentId())
            .board(boardCommentEntity.getBoard())
            .content(boardCommentEntity.getContent())
            .author(boardCommentEntity.getAuthor())
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
    public BoardCommentDto.ResponseDto putBoardComment(String boardCommentId, BoardCommentDto.RequestDto boardCommentRequestDto) {

        // 게시글 댓글 조회
        BoardCommentEntity findBoardCommentEntity = boardCommentRepository.findById(boardCommentId).orElseThrow(NoSuchElementException::new);

        // NOTE: CASE2) repository 메서드에 @EntityGraph 사용하여 연관 객체 조회
//        BoardComment findBoardComment = boardCommentRepository.findByBoardCommentId(boardCommentId).orElseThrow(NoSuchElementException::new);

        // 게시글 댓글 저장
        findBoardCommentEntity.updateBoardComment(
            boardCommentRequestDto.getContent(),
            boardCommentRequestDto.getAuthor()
        );

        // NOTE: could not initialize proxy - no session
        // 연관관계의 FetchType LAZY로 설정된 객체는 조회시 바로 초기화되지 않고 proxy 객체로 처리 됨.
        // 이 상태에서 proxy 객체를 타입 캐스팅하려는 경우 could not initialize proxy - no session 에러가 발생하게 됨.
        // FetchType EAGER로 설정하면 해결되지만 N+1 문제가 발생할 수 있기 때문에 권장되지 않음.
        // CASE1) repository 메서드에 객체그래프 탐색을 위한 @EntityGraph를 사용
        // CASE2) proxy 객체의 값을 꺼내와서 DTO에 담아 반환

        return BoardCommentDto.ResponseDto.builder()
            .boardCommentId(findBoardCommentEntity.getBoardCommentId())
            // NOTE: CASE1) proxy 객체의 값을 꺼내서 DTO에 담아 반환
            .board(
                BoardEntity.builder()
                    .boardId(findBoardCommentEntity.getBoard().getBoardId())
                    .title(findBoardCommentEntity.getBoard().getTitle())
                    .content(findBoardCommentEntity.getBoard().getContent())
                    .author(findBoardCommentEntity.getBoard().getAuthor())
                    .build()
            )
            // NOTE: CASE2) repository 메서드에 @EntityGraph 사용하여 연관 객체 조회
//            .board(findBoardComment.getBoard())
            .content(findBoardCommentEntity.getContent())
            .author(findBoardCommentEntity.getAuthor())
            .build();

    }

    /**
     * 게시글 댓글 삭제
     *
     * @param boardCommentId
     * @throws Exception
     */
    @Transactional
    public void deleteBoardComment(String boardCommentId) {
        // 게시글 댓글 삭제
        boardCommentRepository.deleteById(boardCommentId);
    }

}
