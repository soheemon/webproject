package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import board.model.BoardVo;
import sun.util.logging.resources.logging;
import board.model.BoardDao;

public class boardMapperTest {

	BoardDao dao;

	@Before
	public void testInit() {
		dao = BoardDao.getInstance();
	}

	// 새글등록

	@Test
	public void testInsertBoard() {
		BoardVo board = new BoardVo();
		board.setContents("contents");
		board.setWriter("soheemon");
		for (int index = 0; index < 10; index++) {
			dao.insertBoard(board);
		}
	}

	// 글삭제
	@Ignore
	@Test
	public void testDeleteBoard() {
		if (dao.deleteBoard(1) < 0) {
			fail();
		}
	}

	// 글 디테일 확인
	@Ignore
	@Test
	public void testDetailBoard() {
		BoardVo board = dao.detailBoard(1);
		assertNotNull(board);
	}

	// 글 수정
	@Ignore
	@Test
	public void testUpdateBoard() {
		BoardVo board = new BoardVo();
		board.setContents("modified contents");
		board.setWriter("modified writer");
		dao.boardUpdate(board);
	}

	// 글 리스트 가져오기
	@Ignore
	@Test
	public void testListBoard() {
		List<BoardVo> list = dao.listBoard();
		assertNotNull(list);

		for (BoardVo board : list) {
			System.out.println(board);
		}
	}
}
