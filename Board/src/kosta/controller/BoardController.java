package kosta.controller;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import kosta.action.Action;
import kosta.action.ActionForward;
import kosta.action.BoardInsertAction;
import kosta.action.BoardRedirectAction;
import kosta.action.BoardUpdateAction;
import kosta.action.DeleteBoardAction;
import kosta.action.DetailBoardAction;
import kosta.action.ListBoardAction;

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
    	ActionForward forward = null;
    	Action action = null;
    	switch (ReqUri) {
		case "BoardRedirect.do":
			action = (Action)new BoardRedirectAction();
			forward = ((BoardRedirectAction) action).execute(request, response);
			break;
		case "Boardinsert.do":
			action = (Action)new BoardInsertAction();
			forward = ((BoardInsertAction)action).execute(request, response);
			break;
		case "Boardlist.do":
			action = (Action)new ListBoardAction();
			forward = ((ListBoardAction)action).execute(request, response);
			break;
		case "BoarddeleteAction.do":
			action = (Action)new DeleteBoardAction();
			forward = action.execute(request, response);
			break;
		case "BoardupdateAction.do":
			action = (Action)new DetailBoardAction();
			forward = action.execute(request, response);
			break;
		case "Boardupdate.do":
			action = (Action)new BoardUpdateAction();
			forward = action.execute(request, response);
			break;
			
		default:
			break;
		}
    	doForward(request, response, forward);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
