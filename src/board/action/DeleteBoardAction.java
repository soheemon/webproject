package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.action.ActionForward;


public class DeleteBoardAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		BoardService service = BoardService.getInstance();
		service.DeleteBoardService(request, response);
		
		ActionForward forward = new ActionForward();
		forward.setNextPath("Boardlist.do");
		forward.setRedirect(true);
		return forward;
	}

}