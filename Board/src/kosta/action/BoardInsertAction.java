package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardInsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		BoardService service = BoardService.getInstance();
		service.BoardInsertService(request, response);
		
		ActionForward forward = new ActionForward();
		forward.setNextPath("Boardlist.do");
		forward.setRedirect(true);
		return forward;
	}

}
