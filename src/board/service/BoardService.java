package board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.Board;
import board.model.BoardDao;


public class BoardService {
	//dao 만들�?
	public static BoardDao dao = BoardDao.getInstance();
	public static BoardService service = new BoardService();
	public static BoardService getInstance(){
		return service;
	}
	private BoardService(){};
	
	public void BoardInsertService(HttpServletRequest request, HttpServletResponse response){
		Board newBoard = new Board();
		//newBoard.setSeq(Integer.parseInt(request.getParameter("seq")));
		newBoard.setWriter(request.getParameter("writer"));
		newBoard.setContents(request.getParameter("contents"));
		dao.insertBoard(newBoard);
	}
	public void ListBoardService(HttpServletRequest request, HttpServletResponse response){
		List<Board> list = dao.listBoard();
//		for(Board tmp: list){
//			System.out.println(tmp);
//		}
		request.setAttribute("list", list);
	}
	
	public void DetilBoardService(HttpServletRequest request, HttpServletResponse response){
		int seq = Integer.parseInt(request.getParameter("seq"));
		Board boardDetail = dao.detailBoard(seq);

		request.setAttribute("boardDetail", boardDetail);
	}
	
	public void DeleteBoardService(HttpServletRequest request, HttpServletResponse response){
		int seq = Integer.parseInt(request.getParameter("seq"));
		dao.deleteBoard(seq);
//		for(Board tmp: list){
//			System.out.println(tmp);
//		}
	}
	public void BoardUpdateService(HttpServletRequest request, HttpServletResponse response){
		Board updateBoard = new Board();
		updateBoard.setWriter(request.getParameter("writer"));
		updateBoard.setContents(request.getParameter("contents"));
		updateBoard.setSeq(Integer.parseInt(request.getParameter("seq"))); 
		//System.out.println(updateBoard);
		dao.boardUpdate(updateBoard);
	}
}
