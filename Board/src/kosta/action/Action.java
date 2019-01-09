package kosta.action;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public interface Action {
	//execute를 실행하고 ActionForward에 따라 nextPath로 이동.
	public ActionForward execute (HttpServletRequest request, HttpServletResponse response);
}
