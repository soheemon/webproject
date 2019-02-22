<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script type="text/javascript">
	$(function() {
		//1.모달창 열림->true 2.모달창 닫힘->false
		$('#registerModal').on('show.bs.modal', function(event) {

			var modal = $(this);

			$('#registerBtn').off("click").on('click', function(event) {
				var contents = modal.find('#contents').val();
				var writer = modal.find('#writer').val();
				var title = modal.find('#title').val();
				
				var board = {
					'writer' : writer,
					'contents' : contents,
					'title' : title
				};
				boardService.insertBoard(board, function() {
					console.log('ajax');
					$('#registerModal').modal("hide");
					var contents = modal.find('.form-group textarea').val("");
					var title = modal.find('.form-group input').val("");
					printBoardList();
				});

			})//btnClick
		})//ModalShow
	})
</script>
<script>
	/**
	 * 중복서브밋 방지
	 * 
	 * @returns {Boolean}
	 */
</script>
<div class="modal fade" id="registerModal" tabindex="-1" role="dialog"
	aria-labelledby="registerModal" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h3 class="modal-title" id="registerModal">새글등록</h3>
			</div>

			<div class="modal-body">
				<form>
					<div class="form-group">
						<label for="message-text" class="col-form-label">작성자</label>
						<input
							type="text" class="form-control" id="writer">
					</div>
					<div class="form-group">
						<label for="recipient-name" class="col-form-label">제목</label> <input
							type="text" class="form-control" id="title">
					</div>
					<div class="form-group">
						<label for="message-text" class="col-form-label">내용</label>
						<textarea class="form-control" id="contents"></textarea>
					</div>
				</form>
			</div>

			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
				<button type="button" class="btn btn-primary" id="registerBtn">등록</button>
			</div>
		</div>
	</div>
</div>
