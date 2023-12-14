package com.freestrokes;

import com.freestrokes.domain.BoardEntity;
import com.freestrokes.repository.BoardRepository;
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

import static org.assertj.core.api.Assertions.assertThat;

//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.is;

@ActiveProfiles("dev")
@RequiredArgsConstructor
@RunWith(SpringRunner.class)
@SpringBootTest()
public class PageableWithFetchJoinTests {

	@Autowired
	private BoardRepository boardRepository;

	@Autowired
	private BoardMockService boardMockService;

	@Before
	public void setup() {
//		for (int i = 0; i < 30; i++) {
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
//		boardRepository.deleteAll();
	}

	@Test
	public void contextLoads() {
		Pageable pageable = PageRequest.of(0, 10);
		Page<BoardEntity> findBoards = boardRepository.findAll(pageable);
		assertThat(findBoards.getSize()).isEqualTo(10);
	}

}
