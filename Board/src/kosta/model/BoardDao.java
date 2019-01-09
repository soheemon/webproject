package kosta.model;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kosta.mapper.BoardMapper;

public class BoardDao {
	//싱글톤 패턴
	public static BoardDao dao = new BoardDao(); //최초 1회 생성
	public static BoardDao getInstance() {
		return dao;
	} //static이라 메모리에 계속 떠있으면서 재사용 가능하다.
	
	private BoardDao() {}//생성자 사용 막음.
	
public SqlSessionFactory getSqlSessionFactory() {
	String resource = "mybatis-config.xml";
	InputStream in = null;
	
	try {
		in = Resources.getResourceAsStream(resource);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return new SqlSessionFactoryBuilder().build(in);
}

public int insertBoard(Board board) {
	int queryResult = -1;
	SqlSession sqlSession = null;
		sqlSession = getSqlSessionFactory().openSession();		
	
	try {
		queryResult = sqlSession.getMapper(BoardMapper.class).insertBoard(board);
		
		if(queryResult > 0) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return queryResult;
}

public int deleteBoard(int seq) {
	int queryResult = -1;
	SqlSession sqlSession = null;
		sqlSession = getSqlSessionFactory().openSession();		
	
	try {
		queryResult = sqlSession.getMapper(BoardMapper.class).deleteBoard(seq);
		
		if(queryResult > 0) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return queryResult;
}

public List<Board> listBoard() {
	List<Board> list = null;
	SqlSession sqlSession = null;
		sqlSession = getSqlSessionFactory().openSession();		
	
	try {
		list = sqlSession.getMapper(BoardMapper.class).listBoard();
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return list;
}

public Board detailBoard(int seq) {
	Board board = null;
	SqlSession sqlSession = null;
		sqlSession = getSqlSessionFactory().openSession();		
	
	try {
		board = sqlSession.getMapper(BoardMapper.class).detailBoard(seq);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return board;
}
public int boardUpdate(Board board) {
	int queryResult = -1;
	SqlSession sqlSession = null;
		sqlSession = getSqlSessionFactory().openSession();		
	
	try {
		queryResult = sqlSession.getMapper(BoardMapper.class).updateBoard(board);
		
		if(queryResult > 0) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return queryResult;
}
}
