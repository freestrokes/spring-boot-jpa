package com.freestrokes.service;

import com.freestrokes.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public List getBoardList () throws Exception {

        List result = boardRepository.findAll();

//        boolean complete = false;
//        if( param.getCommentStatus().size()==1 ) {
//            for (BoardConstants.COMMENT_STATUS commentStatus : param.getCommentStatus()) {
//                complete = commentStatus == BoardConstants.COMMENT_STATUS.COMPLETE;
//            }
//        }
//
//        /*
//        Page<BoardMessage> boardList = boardMessageRepository.findByQDSLSearchValues(
//                param.getKeyword()
//                ,param.getBoardType()
//                ,param.getBoardCategory()
//                ,param.getCommentStatus()
//                ,complete
//                ,pageable);
//
//
//        Page<BoardMessageDTO.BoardMessage> result = new PageImpl<>(BoardMessageMapper.INSTANCE.toDto(boardList.getContent()),pageable,boardList.getTotalElements());
//        */
//
//        Page<BoardMessage> boardList = boardMessageRepository.findByQDSLSearchValues(
//                param
//                ,pageable);
//
//        Page<BoardMessageDTO.BoardMessage> result = new PageImpl<>(BoardMessageMapper.INSTANCE.toDto(boardList.getContent()),pageable,boardList.getTotalElements());
        return result;
    }

}
