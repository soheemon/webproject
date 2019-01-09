package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DetailBoardAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		BoardService service = BoardService.getInstance();
		service.DetilBoardService(request, response);
		
		ActionForward forward = new ActionForward();
		forward.setNextPath("Boardlist.do");
		forward.setRedirect(false);
		return forward;
	}

}
