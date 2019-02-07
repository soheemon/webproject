package test;

import static org.junit.Assert.*;

import org.junit.Before;
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
		
	}
	
	//글 수정
	@Test
	public void testUpdateBoard() {
		
	}
	
	//글 리스트 가져오기
	@Test
	public void testListBoard() {
		
	}
}
