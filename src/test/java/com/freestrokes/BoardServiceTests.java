package com.freestrokes;

import com.freestrokes.domain.Board;
import com.freestrokes.domain.BoardComment;
import com.freestrokes.repository.BoardCommentRepository;
import com.freestrokes.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

//import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@ActiveProfiles("dev")
@RequiredArgsConstructor
@RunWith(SpringRunner.class)
@SpringBootTest()
public class BoardServiceTests {

	@Autowired
	private BoardRepository boardRepository;

	@Autowired
	private BoardCommentRepository boardCommentRepository;

	@Before
	public void setup() {
		// 게시글 생성
		Board board = Board.builder()
			.title("board title test")
			.content("board content test")
			.author("board author test")
			.build();

		// 게시글 저장
		boardRepository.save(board);

		for (int i = 0; i < 10; i++) {
			// 게시글 댓글 생성
			BoardComment boardComment = BoardComment.builder()
				.board(board)
				.content("board comment test " + i)
				.author("board comment test " + i)
				.build();

			// 게시글 댓글 저장
			boardCommentRepository.save(boardComment);
		}
	}

	@After
	public void cleanAll() {
		boardCommentRepository.deleteAll();
		boardRepository.deleteAll();
	}

	@Test
	public void contextLoads() {
		List<BoardComment> boardComments = boardCommentRepository.findAll();
		assertThat(boardComments.size(), is(10));
	}

}
