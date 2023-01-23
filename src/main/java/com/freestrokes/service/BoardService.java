package com.freestrokes.service;

import com.freestrokes.domain.Board;
import com.freestrokes.dto.BoardDto;
import com.freestrokes.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public List<BoardDto.ResponseDto> getBoards() throws Exception {
        List<BoardDto.ResponseDto> boardsResponseDto = boardRepository.findAll()
            .stream()
            .map(item -> {
                return BoardDto.ResponseDto.builder()
                    .boardId(item.getBoardId())
                    .title(item.getTitle())
                    .content(item.getContent())
                    .author(item.getAuthor())
                    .boardComments(item.getBoardComments())
                    .build();
            })
            .collect(Collectors.toList());

        return boardsResponseDto;
    }

    public BoardDto.ResponseDto postBoard(BoardDto.RequestDto boardRequestDto) throws Exception {
        Board board = boardRepository.save(boardRequestDto.toEntity());

        // TODO: Optional을 이용한 중복 체크가 필요한 경우 아래와 같이 사용.
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

    public BoardDto.ResponseDto putBoard(Long id, BoardDto.RequestDto boardRequestDto) throws Exception {
        Optional<Board> persistBoard = boardRepository.findById(id);

        if (persistBoard.isPresent()) {
            Board board = Board.builder()
                .title(boardRequestDto.getTitle())
                .content(boardRequestDto.getContent())
                .author(boardRequestDto.getAuthor())
                .build();

            persistBoard.get().update(board);

            boardRepository.save(persistBoard.get());
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

    public void deleteBoard(Long id) throws Exception {
        boardRepository.deleteById(id);
    }

}
