package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.action.ActionForward;

public class ListBoardAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {	
		ActionForward forward = new ActionForward();
		BoardService service = BoardService.getInstance();
		service.ListBoardService(request, response);
		
		forward.setNextPath("Boardlist.jsp");
		forward.setRedirect(false);
		return forward;
	}
}