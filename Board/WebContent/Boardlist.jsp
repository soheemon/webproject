<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>블로그</title>
<style>
.singleBoard {
    padding-top: 50;
    padding-bottom: 50;
    border-color: black;
    border-style: double;
    border-width: thin;
    width: 400;
}
.Boardmenu {
    padding-top: 10;
}
</style>
</head>
<body>
	<!-- Form submit 설정 -->							
	
	<c:choose>
	<c:when test="${boardDetail != null}">
		<c:set var="writer" value="${boardDetail.writer}"/>
		<c:set var="contents" value="${boardDetail.contents}"/>
		
		<c:set var="subm" value="Boardupdate.do?seq=${boardDetail.seq}"/>
	</c:when>
	<c:otherwise>
		<c:set var="writer" value=""/>
		<c:set var="contents" value=""/>
		
		<c:set var="subm" value="Boardinsert.do"/>
	</c:otherwise>
	</c:choose>	
	<form action="${subm}" method="post" style="width: 620; margin: auto;">
		<input type="text" name="writer" style="width: 200;" value="${writer}">
		<textarea rows="6" cols="70" name="contents">${contents}</textarea>
		<input type="submit" value="등록">
	</form>
	
	<div align="center">
	<c:forEach var="board" items='${list}'>
	<div class="singleBoard">
				<div>
					<span>${board.writer}</span>
					<span>${board.regdate}</span>
				</div>
				<div id="contents">
				    <p>${board.contents}</p>
				</div>
			
		<c:choose > 
			<c:when test="${reply == null}">댓글이 존재하지 않습니다.</c:when>
			<c:otherwise>		
			<div class="reply">
			    <span>댓글 작성자</span>
			    <span>내용</span>
			</div>
			</c:otherwise>
		</c:choose>
		<div class="Boardmenu">
			<span><a href="BoardupdateAction.do?seq=${board.seq}">수정</a></span>
			<span><a href="BoarddeleteAction.do?seq=${board.seq}">삭제</a></span>
		</div>
	</div>
	</c:forEach>
	</div>

</body>
</html>