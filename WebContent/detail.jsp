<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- Button trigger modal -->
<!-- show 될때 ajax요청 보내야 합니다. detailboard요청. -->

<script type="text/javascript">
	$('#detailModal').on('show.bs.modal', function(event) {
		var button = $(event.relatedTarget) // Button that triggered the modal
		var recipient = button.data('whatever') // Extract info from data-* attributes
		// If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
		// Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
		var modal = $(this)
		modal.find('.modal-title').text('New message to ' + recipient)
		modal.find('.modal-body input').val(recipient)
	})
</script>

<!-- Modal -->
<div class="modal fade" id="detailModal" tabindex="-1"
	role="dialog" aria-labelledby="exampleModalCenterTitle"
	aria-hidden="true">

	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h3 class="modal-title" id="exampleModalLongTitle">글상세보기</h3>

			</div>
			<!-- contents -->
			<div class="modal-body">
				<div class="board-body">
					<h5>작성자</h5>
					<p class="board-body" id="boardWriter">soheemon</p>
					<hr>
					<h5>제목</h5>
					<p class="board-body" id="boardTitle">안녕하세요</p>
					<hr>
					<h5>내용</h5>
					<p class="board-body" id="boardContents">반갑습니다.</p>
				</div>
			</div>
			<!-- buttons -->
			<div class="modal-footer">

				<button type="button" class="btn btn-secondary pull-left">수정</button>
				<button type="button" class="btn btn-secondary pull-left">삭제</button>
				<button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
			</div>
		</div>
	</div>
</div>
