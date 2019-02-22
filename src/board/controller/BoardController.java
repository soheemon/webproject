package board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.action.Action;
import board.action.ActionForward;
import board.action.BoardRedirectAction;
import board.service.BoardService;


@WebServlet("*.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

    public BoardController() {};
    public String getReqUri (HttpServletRequest request) {
    	String fullUri = request.getRequestURI();
    	String contextPath = request.getContextPath();
    	
    	int endIndex = fullUri.length();
    	int beginIndex = contextPath.length();
    	
    	String ReqUri = fullUri.substring(beginIndex + 1, endIndex);
    	System.out.println(ReqUri);
    	return ReqUri;
    }
    
    public void doForward(HttpServletRequest request, HttpServletResponse response, ActionForward forward){
    	if(forward.isRedirect() == true) {
    		try { //sendRedirect
				response.sendRedirect(forward.getNextPath());
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}else{ //dispatcher
    		RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getNextPath());
    		try {
				dispatcher.forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
    	}
    }
    
    public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	
    	request.setCharacterEncoding("utf-8");
    	String ReqUri = getReqUri(request);
    	
    	BoardService service = BoardService.getInstance();
    	switch (ReqUri) {
		case "BoardInsert.do":
			System.out.println("BoardInsert");
			service.BoardInsertService(request, response);
			break;
		case "BoardList.do":
			System.out.println("BoardList");
			service.ListBoardService(request, response);
			break;
		case "BoardDetail.do":
			System.out.println("BoardDetail");
			service.DetailBoardService(request, response);
			break;
		case "BoardUpdate.do":
			System.out.println("BoardUpdate");
			service.BoardUpdateService(request, response);
			break;
		default:
			break;
		}
    	
    	//doForward(request, response, forward);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
}
