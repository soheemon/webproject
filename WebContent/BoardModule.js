/**
 * board 서비스 Ajax
 */

var boardService = (function() {
	var boardControlUrl = {
		insert: 'BoardInsert.do',
		delete: 'BoardDelete.do',
		detail: 'BoardDetail.do',
		getlist: 'BoardList.do',
		update: 'BoardUpdate.do'
	};
	
	function insertBoard(board, callback, error) {
		console.log("add board.....");
		$.ajax({
			type:'post',
			url: boardControlUrl.insert,
			data: JSON.stringify(board),
			contentType:"application/json; charset=utf-8",
			success: function(result, status, xhr){
				if(callback) {
					callback(result);
				}
			},// success
			error: function(xhr, status, er){
				if(error) {
					error(er)
				}
			}// error
		})// ajax
	}// insert
	
	function deleteBoard(seq, callback, error) {
		$.ajax({
			type: 'get',
			url: boardControlUrl.delete + '?' + 'seq=' + seq,
			success: function(result, status, xhr){
				if(callback) {
					callback(result);
				}
			},// success
			error: function(xhr, status, er){
				if(error) {
					error(er)
				}
			}// error
		})// ajax
	}// delete
	
	function detailBoard(seq, callback, error) {
		$.ajax({
			type: 'get',
			url: boardControlUrl.detail + '?' + 'seq=' + seq,
			success: function(result, status, xhr){
				if(callback) {
					callback(result);
				}
			},// success
			error: function(xhr, status, er){
				if(error) {
					error(er)
				}
			}// error
		})// ajax
	}// detail
	
	function getList(callback, error) {
		$.ajax({
			type: 'get',
			url: boardControlUrl.getlist,
			contentType:"application/json; charset=utf-8",
			success: function(result, status, xhr){
				if(callback) {
					callback(result);
				}
			},// success
			error: function(xhr, status, er){
				if(error) {
					error(er)
				}
			}// error
		})// ajax
	}// list
	
	function updateBoard(board, callback, error) {
		console.log("update board.....");
		$.ajax({
			type:'post',
			url: boardControlUrl.update,
			data: JSON.stringify(board),
			contentType:"application/json; charset=utf-8",
			success: function(result, status, xhr){
				if(callback) {
					callback(result);
				}
			},// success
			error: function(xhr, status, er){
				if(error) {
					error(er)
				}
			}// error
		})// ajax
	}// insert

	
	return {
		insertBoard:insertBoard,
		deleteBoard:deleteBoard,
		detailBoard:detailBoard,
		getList:getList,
		updateBoard:updateBoard
			};
			
})();// 선언과 동시에 실행
