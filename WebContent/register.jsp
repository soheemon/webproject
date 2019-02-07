<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script type="text/javascript">
	$(function() {
		$('#registerModal').on('show.bs.modal', function(event) {
//			var button = $(event.relatedTarget) // Button that triggered the modal
//			var recipient = button.data('whatever') // Extract info from data-* attributes
//			console.log(recipient);

			var modal = $(this);
			$('#registerBtn').on('click', function(event) {
				var contents = modal.find('.form-group textarea').val();
				var title = modal.find('.form-group input').val();
				//console.log(contents, title);
				var board = {
						'writer':'sohee',
						'contents':contents
				};
				boardService.insertBoard(board, function(){
					$('#registerModal').modal("hide");
					printBoardList();
				});
			})
		})
	})
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

