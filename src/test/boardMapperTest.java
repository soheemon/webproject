package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import board.model.BoardVo;
import board.model.BoardDao;

public class boardMapperTest {
	
	BoardDao dao;
	@Before
	public void testInit() {
		dao = BoardDao.getInstance();
	}
	
	//새글등록
	@Test
	public void testInsertBoard() {
		BoardVo board = new BoardVo();
		board.setContents("contents");
		board.setWriter("soheemon");
		dao.insertBoard(board);
	}
	
	//글삭제
	@Test
	public void testDeleteBoard() {
		dao.deleteBoard(1);
	}
	
	//글 디테일 확인
	@Test
	public void testDetailBoard() {
		dao.detailBoard(1);
	}
	
	//글 수정
	@Test
	public void testUpdateBoard() {
		BoardVo board = new BoardVo();
		board.setContents("modified contents");
		board.setWriter("modified writer");
		dao.boardUpdate(board);
	}
	
	//글 리스트 가져오기
	@Test
	public void testListBoard() {
		dao.listBoard();
	}
}
