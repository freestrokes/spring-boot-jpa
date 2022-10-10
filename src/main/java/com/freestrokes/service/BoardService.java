package com.freestrokes.service;

import com.freestrokes.domain.Board;
import com.freestrokes.dto.BoardDto;
import com.freestrokes.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public List getBoards() throws Exception {
        List result = boardRepository.findAll();
        return result;
    }

    public Board postBoard(BoardDto boardDto) throws Exception {
        Board board = boardRepository.save(boardDto.toEntity());
        return board;
    }

    public Board putBoard(Long id, BoardDto boardDto) throws Exception {
        Optional<Board> board = boardRepository.findById(id);

        if (board.isPresent()) {
            board.get().setTitle(boardDto.getTitle());
            board.get().setContent(boardDto.getContent());
            board.get().setAuthor(boardDto.getAuthor());
            boardRepository.save(board.get());
        }

        return board.get();
    }

    public void deleteBoard(Long id) throws Exception {
        boardRepository.deleteById(id);
    }

}
