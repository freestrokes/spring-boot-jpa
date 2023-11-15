package com.freestrokes;

import com.freestrokes.domain.BoardCommentEntity;
import com.freestrokes.domain.BoardEntity;
import com.freestrokes.dto.BoardDto;
import com.freestrokes.repository.BoardCommentRepository;
import com.freestrokes.repository.BoardRepository;
import com.freestrokes.service.BoardCommentMockService;
import com.freestrokes.service.BoardMockService;
import lombok.RequiredArgsConstructor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.is;

@ActiveProfiles("dev")
@RequiredArgsConstructor
@RunWith(SpringRunner.class)
@SpringBootTest()
public class PageableTests {

	@Autowired
	private BoardRepository boardRepository;

	@Autowired
	private BoardCommentRepository boardCommentRepository;

	@Autowired
	private BoardMockService boardMockService;

	@Autowired
	private BoardCommentMockService boardCommentMockService;

	@Before
	public void setup() {
//		for (int i = 0; i < 5; i++) {
//			// 게시글 생성
//			BoardEntity boardEntity = BoardEntity.builder()
//				.title("board title test")
//				.content("board content test")
//				.author("board author test")
//				.build();
//
//			// 게시글 저장
//			boardRepository.save(boardEntity);
//		}
	}

	@After
	public void cleanAll() {
//		boardCommentRepository.deleteAll();
//		boardRepository.deleteAll();
	}

	@Test
	public void contextLoads() {
		Pageable pageable = PageRequest.of(0, 10);

		Page<BoardEntity> findBoards = boardRepository.findAll(pageable);

//		Page<BoardEntity> findBoards = boardRepository.findAllByEntityGraphWithPaging(pageable);

//		List<BoardDto.ResponseDto> boardsResponseDto = new ArrayList<>();

		// 조회한 게시글 목록에 대한 DTO 변환 (Pageable)
//		findBoards.getContent().forEach(boardEntity -> {
//			boardsResponseDto.add(
//				BoardDto.ResponseDto.builder()
//					.boardId(boardEntity.getBoardId())
//					.title(boardEntity.getTitle())
//					.content(boardEntity.getContent())
//					.author(boardEntity.getAuthor())
//					.boardComments(
//						boardEntity.getBoardComments().stream().map(boardComment -> {
//							return BoardCommentEntity.builder()
//								.boardCommentId(boardComment.getBoardCommentId())
//								.board(boardEntity)
//								.content(boardComment.getContent())
//								.author(boardComment.getAuthor())
//								.build();
//						}).collect(Collectors.toList())
//					)
//					.build()
//			);
//		});

		assertThat(findBoards.getSize()).isEqualTo(10);

	}

}
