package board.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardVo;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import board.model.BoardDao;

public class BoardService {
	// dao 만들�?
	public static BoardDao dao = BoardDao.getInstance();
	public static BoardService service = new BoardService();

	public static BoardService getInstance() {
		return service;
	}

	private BoardService() {
	};

	public void BoardInsertService(HttpServletRequest request, HttpServletResponse response) {
		BoardVo newBoard = new BoardVo();
		// newBoard.setSeq(Integer.parseInt(request.getParameter("seq")));
		newBoard.setWriter(request.getParameter("writer"));
		newBoard.setContents(request.getParameter("contents"));
		dao.insertBoard(newBoard);
	}

	public void ListBoardService(HttpServletRequest request, HttpServletResponse response) {
		List<BoardVo> list = dao.listBoard();

		if (list.size() <= 0) {
			return;
		}

		JSONArray jsonarr = new JSONArray();
		jsonarr = JSONArray.fromObject(list);
		
		sendResponse(response, jsonarr);

	}

	public void DetailBoardService(HttpServletRequest request, HttpServletResponse response) {
		int seq = Integer.parseInt(request.getParameter("seq"));
		BoardVo boardDetail = dao.detailBoard(seq);
		
		JSONObject jsonobj = new JSONObject();
		jsonobj = JSONObject.fromObject(boardDetail);
		sendResponse(response, jsonobj);
		// request.setAttribute("boardDetail", boardDetail);
	}

	public void DeleteBoardService(HttpServletRequest request, HttpServletResponse response) {
		int seq = Integer.parseInt(request.getParameter("seq"));
		dao.deleteBoard(seq);
		// for(Board tmp: list){
		// System.out.println(tmp);
		// }
	}

	public void BoardUpdateService(HttpServletRequest request, HttpServletResponse response) {
		BoardVo updateBoard = new BoardVo();
		updateBoard.setWriter(request.getParameter("writer"));
		updateBoard.setContents(request.getParameter("contents"));
		updateBoard.setSeq(Integer.parseInt(request.getParameter("seq")));
		// System.out.println(updateBoard);
		dao.boardUpdate(updateBoard);
	}

	public static String getBody(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// String requestBody = getBody(request, response);
		// JSONParser jsonParser = new JSONParser();
		// JSONObject jsonData = (JSONObject) jsonParser.parse(requestBody);
		//
		// String desContents = (String)jsonData.get("desContents");
		// DescriptionDTO description = new DescriptionDTO();
		// //설명내용 받아와 셋팅
		// description.setD_contents(desContents);
		// //훗날 수정필요 >> 포스트 넘버 받아와 셋팅
		// description.setP_no(1);
		// PostDao dao = PostDao.getInstance();
		//
		// dao.insertDescription(description);

		String body = "";
		StringBuilder stringBuilder = new StringBuilder();
		BufferedReader bufferedReader = null;

		try {
			InputStream inputStream = request.getInputStream();
			if (inputStream != null) {
				bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
				char[] charBuffer = new char[128];
				int bytesRead = -1;
				while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
					stringBuilder.append(charBuffer, 0, bytesRead);
				}
			} else {
				stringBuilder.append("");
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (Exception e2) {
					throw e2;
				}
			}
		}
		body = stringBuilder.toString();
		return body;
	}
	
	public void sendResponse(HttpServletResponse response, JSONArray jsonarr) {
		System.out.println(jsonarr.toString());
		response.setCharacterEncoding("utf-8");
		// response.getWriter().print(jsonarr.toString());

		PrintWriter pw = null;
		try {
			pw = response.getWriter();
			pw.print(jsonarr.toString());
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (pw != null) {
				pw.close();
			}
		}
	}
	
	public void sendResponse(HttpServletResponse response, JSONObject jsonobj) {
		System.out.println(jsonobj.toString());
		response.setCharacterEncoding("utf-8");
		// response.getWriter().print(jsonarr.toString());

		PrintWriter pw = null;
		try {
			pw = response.getWriter();
			pw.print(jsonobj.toString());
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (pw != null) {
				pw.close();
			}
		}
	}
}
