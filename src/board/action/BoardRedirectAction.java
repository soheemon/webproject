package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.action.ActionForward;

public class BoardRedirectAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		ActionForward forward = new ActionForward();
		
		//redirect 하자마자 데이터를 뿌려줘야 해!
		BoardService service = BoardService.getInstance();
		service.ListBoardService(request, response);
		
		forward.setRedirect(false);
		forward.setNextPath("Boardlist.jsp");
		return forward;
	}

}
