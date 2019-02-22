<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
<title>Board JSP&Servlet</title>
<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<!-- 부트스트랩 -->
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script type="text/javascript" src="BoardModule.js"></script>
<script type="text/javascript">
$(function(){
	printBoardList();
});
	function printBoardList() {
		boardService.getList(function(data) {
			var boardList = JSON.parse(data);

			var tbody = document.getElementsByTagName("tbody")[0];
			$('tbody').empty();//중복방지를 위해 비우고 시작
			
			boardList.forEach(function(board) {
				var boardMarkdown = 
					'<tr data-toggle="modal" data-target="#detailModal"' + 'id=' + board.seq +'>' + 
						'<td>' + board.seq + '</td>' + 
						'<td>' + board.title + '</td>' + 
						'<td>' + board.writer + '</td>' + 
						'<td>' + board.regdate + '</td>' + 
					'</tr>';
					
				$('tbody').append(boardMarkdown);
			});
		});
	}
</script>
</head>
<body>

	<div class="container">
		<h1>
			Board <small>JSP&Servlet</small>
		</h1>
		<table class="table table-hover">
			<thead>
				<tr>
					<th scope="col">글번호
					</th>
					<th scope="col">제목
					</th>
					<th scope="col">작성자
					</th>
					<th scope="col">작성일
					</th>
				</tr>
			</thead>
			<tbody>
				<!-- 글목록 추가 -->
				<%@include file="detail.jsp"%>

			</tbody>
		</table>
		<!-- 글등록 Modal -->
		<%@include file="register.jsp"%>
		<button type="button" class="btn btn-secondary pull-right"
			data-toggle="modal" data-target="#registerModal" data-whatever="@mdo">글쓰기</button>

		<!-- paging -->
		<div class="text-center">
			<ul class="pagination">
				<li><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
			</ul>
		</div>
	</div>
</body>
</html>