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
        List<BoardDto.ResponseDto> boardsDto = boardRepository.findAll()
            .stream()
            .map(item -> {
                return BoardDto.ResponseDto.builder()
                    .id(item.getId())
                    .title(item.getTitle())
                    .content(item.getContent())
                    .author(item.getAuthor())
                    .build();
            })
            .collect(Collectors.toList());

        return boardsDto;
    }

    public BoardDto.ResponseDto postBoard(BoardDto.RequestDto boardRequestDto) throws Exception {
        Board board = boardRepository.save(boardRequestDto.toEntity());

        BoardDto.ResponseDto boardDto = BoardDto.ResponseDto.builder()
            .id(board.getId())
            .title(board.getTitle())
            .content(board.getContent())
            .author(board.getAuthor())
            .build();

        return boardDto;
    }

    public BoardDto.ResponseDto putBoard(Long id, BoardDto.RequestDto boardRequestDto) throws Exception {
        Optional<Board> persistBoard = boardRepository.findById(id);

//        persistBoard.ifPresent(board -> {
//           // TODO
//        });

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

        BoardDto.ResponseDto boardDto = BoardDto.ResponseDto.builder()
            .id(persistBoard.get().getId())
            .title(persistBoard.get().getTitle())
            .content(persistBoard.get().getContent())
            .author(persistBoard.get().getAuthor())
            .build();

        return boardDto;

    }

    public void deleteBoard(Long id) throws Exception {
        boardRepository.deleteById(id);
    }

}
