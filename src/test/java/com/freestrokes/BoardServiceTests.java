package com.freestrokes;

import com.freestrokes.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RequiredArgsConstructor
@RunWith(SpringRunner.class)
@SpringBootTest()
public class BoardServiceTests {

	@Autowired
	private BoardRepository boardRepository;

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
