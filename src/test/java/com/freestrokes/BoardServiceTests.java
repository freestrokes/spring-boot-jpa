package com.freestrokes;

import com.freestrokes.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RequiredArgsConstructor
@RunWith(SpringRunner.class)
public class BoardServiceTests {

	private final BoardRepository boardRepository;

	@Before
	public void setup() {
	}

	@After
	public void cleanAll() {
		boardRepository.deleteAll();
	}

	@Test
	public void contextLoads() {
	}

}
