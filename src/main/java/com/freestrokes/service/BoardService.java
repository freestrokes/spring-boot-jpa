package com.freestrokes.service;

import com.freestrokes.domain.Board;
import com.freestrokes.domain.BoardComment;
import com.freestrokes.dto.BoardDto;
import com.freestrokes.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    /**
     * 게시글 목록 조회
     *
     * @return
     * @throws Exception
     */
    // TODO: @Transactional(readOnly = true)
    // 서비스 계층에서 트랙잭션을 시작하면 repository 계층에서도 해당 트랜잭션을 전파 받아서 사용.
    // 지연 로딩 시점까지 세션을 유지하여 LazyInitializationException 해결 가능.
    // 아래와 같이 세션 유지가 필요한 메서드에 @Transactional(readOnly = true) 붙여줌.
    @Transactional(readOnly = true)
    public List<BoardDto.ResponseDto> getBoards() throws Exception {
        // TODO: CASE1) 1:N 양방향 매핑 조회 후 DTO 변환
        List<BoardDto.ResponseDto> boardsResponseDto = boardRepository.findAll()
            .stream()
            .map(board -> {
                return BoardDto.ResponseDto.builder()
                    .boardId(board.getBoardId())
                    .title(board.getTitle())
                    .content(board.getContent())
                    .author(board.getAuthor())
                    .boardComments(
                        board.getBoardComments().stream().map(boardComment -> {
                            return BoardComment.builder()
                                .boardCommentId(boardComment.getBoardCommentId())
                                .board(board)
                                .content(boardComment.getContent())
                                .author(boardComment.getAuthor())
                                .build();
                        }).collect(Collectors.toList())
                    )
                    .build();
            })
            .collect(Collectors.toList());

        //TODO: CASE2) 1:N 양방향 매핑 조회 후 DTO 변환
//        List<Board> boardList = boardRepository.findAll();
//        List<BoardDto.ResponseDto> boardsResponseDto = new ArrayList<>();
//
//        for (Board board : boardList) {
//            List<BoardComment> boardComments = new ArrayList<>();
//
//            // Board Comment DTO
//            if (board.getBoardComments().size() > 0) {
//                board.getBoardComments().stream().forEach(boardComment -> {
//                    boardComments.add(
//                        BoardComment.builder()
//                            .boardCommentId(boardComment.getBoardCommentId())
//                            .board(board)
//                            .content(boardComment.getContent())
//                            .author(boardComment.getAuthor())
//                            .build()
//                    );
//                });
//            }
//
//            // Board DTO
//            boardsResponseDto.add(
//                BoardDto.ResponseDto.builder()
//                    .boardId(board.getBoardId())
//                    .title(board.getTitle())
//                    .content(board.getContent())
//                    .author(board.getAuthor())
//                    .boardComments(boardComments)
//                    .build()
//            );
//        }

        return boardsResponseDto;
    }

    /**
     * 게시글 등록
     *
     * @param boardRequestDto
     * @return
     * @throws Exception
     */
    @Transactional
    public BoardDto.ResponseDto postBoard(BoardDto.RequestDto boardRequestDto) throws Exception {
        Board board = boardRepository.save(boardRequestDto.toEntity());

        // TODO: Optional을 이용한 중복 체크가 필요한 경우
//        Optional<Board> existBoard = boardRepository.findByTitle(boardRequestDto.getTitle());
//        existBoard.ifPresent(item -> {
//            try {
//                throw new Exception();
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//        });

        BoardDto.ResponseDto boardResponseDto = BoardDto.ResponseDto.builder()
            .boardId(board.getBoardId())
            .title(board.getTitle())
            .content(board.getContent())
            .author(board.getAuthor())
            .build();

        return boardResponseDto;
    }

    /**
     * 게시글 수정
     *
     * @param id
     * @param boardRequestDto
     * @return
     * @throws Exception
     */
    @Transactional
    public BoardDto.ResponseDto putBoard(String id, BoardDto.RequestDto boardRequestDto) throws Exception {
        Optional<Board> persistBoard = boardRepository.findById(id);

        if (persistBoard.isPresent()) {
            // TODO: repository save() 호출 없이 저장하려는 경우
            // @Transactional 어노테이션을 명시해주면 가능.
            // board builder() 생성 없이 persistBoard > updateBoard() 호출하는 것 만으로도 저장 가능
            persistBoard.get().updateBoard(
                boardRequestDto.getTitle(),
                boardRequestDto.getContent(),
                boardRequestDto.getAuthor()
            );

            // TODO: @Transactional 어노테이션이 없이 update 하려는 경우
//            Board board = Board.builder()
//                .title(boardRequestDto.getTitle())
//                .content(boardRequestDto.getContent())
//                .author(boardRequestDto.getAuthor())
//                .build();
//
//            persistBoard.get().updateBoard(board);
//
//            boardRepository.save(persistBoard.get());
        } else {
            throw new NoSuchElementException();
        }

        BoardDto.ResponseDto boardResponseDto = BoardDto.ResponseDto.builder()
            .boardId(persistBoard.get().getBoardId())
            .title(persistBoard.get().getTitle())
            .content(persistBoard.get().getContent())
            .author(persistBoard.get().getAuthor())
            .build();

        return boardResponseDto;

    }

    /**
     * 게시글 삭제
     *
     * @param id
     * @throws Exception
     */
    @Transactional
    public void deleteBoard(String id) throws Exception {
        boardRepository.deleteById(id);
    }

}
