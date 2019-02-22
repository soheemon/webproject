<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- Button trigger modal -->
<!-- show 될때 ajax요청 보내야 합니다. detailboard요청. -->

<script type="text/javascript">
	$(function() {
		var seq;
		var btnTgl = false;
		$('#detailModal').on('show.bs.modal', function(event) {
			var modal = $(this);

			var tr = $(event.relatedTarget);
			seq = tr.context.getAttribute('id'); //클릭한 modal의 글번호를 받아온다.

			boardService.detailBoard(seq, function(data) {
				var board = JSON.parse(data);
				//내용 확인용
				modal.find('#boardWriter').text(board.writer);
				modal.find('#boardTitle').text(board.title);
				modal.find('#boardContents').text(board.contents);

				//가려져있는 수정Form에 값을 미리 넣어둔다.
				modal.find('#modifyWriter').val(board.writer);
				modal.find('#modifyTitle').val(board.title);
				modal.find('#modifyContents').val(board.contents);
			});

			//modal load될때 init.
			$('#modifyForm').hide();
			$('#detailForm').show();
			btnTgl = true;
		});
		//버튼 1, 2를 만들어서.
		//1 => Form 보여주게 한다.
		//2 => Form에 있는 내용을 update()한다.

		$('#modifyFormShow').off('click').on('click', function() {
			if (btnTgl) {
				//form에 detail data 넣어주기.
				var data = {
					"seq" : window.seq,
					"writer" : $('#modifyWriter').val(),
					"title" : $('#modifyTitle').val(),
					"contents" : $('#modifyContents').val()
				};
				$('#modifyForm').show();
				$('#detailForm').hide();

				btnTgl = false;
			} else {
				$('#modifyForm').hide();
				$('#detailForm').show();
				btnTgl = true;
			}
			$('#modifySubmit').off('click').on('click', function() {
				//form에 detail data 넣어주기.
				var data = {
					"seq" : seq,
					"writer" : $('#modifyWriter').val(),
					"title" : $('#modifyTitle').val(),
					"contents" : $('#modifyContents').val()
				};
				boardService.updateBoard(data, function() {
					alert('수정되었습니다.');
					$('#modifyForm').hide();
					$('#detailForm').show();
					btnTgl = true;
					$('#detailModal').hide();
					printBoardList();
				});

			});

			$('#remove').on('click', function() {
				alert('test');
			});
		})
	});
</script>

<!-- Modal -->
<div class="modal fade" id="detailModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalCenterTitle" aria-hidden="true">

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
			<div class="modal-body" id="detailForm">
				<div class="board-body">
					<h5>작성자</h5>
					<p class="board-body" id="boardWriter"></p>
					<hr>
					<h5>제목</h5>
					<p class="board-body" id="boardTitle"></p>
					<hr>
					<h5>내용</h5>
					<p class="board-body" id="boardContents"></p>
				</div>
			</div>
			<div class="modal-body" id="modifyForm" style="display: none">
				<div class="form-group">
					<label for="recipient-name" class="col-form-label">작성자</label> <input
						type="text" class="form-control" id="modifyWriter">
				</div>
				<div class="form-group">
					<label for="recipient-name" class="col-form-label">제목</label> <input
						type="text" class="form-control" id="modifyTitle">
				</div>
				<div class="form-group">
					<label for="message-text" class="col-form-label">내용</label>
					<textarea class="form-control" id="modifyContents"></textarea>
				</div>

			</div>
			<!-- buttons -->
			<div class="modal-footer">

				<button type="button" class="btn btn-secondary pull-left"
					id="modifyFormShow">수정</button>
				<button type="button" class="btn btn-secondary pull-left"
					id="modifySubmit">수정완료</button>
				<button type="button" class="btn btn-secondary pull-left"
					id="remove">삭제</button>
				<button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
			</div>
		</div>
	</div>
</div>
