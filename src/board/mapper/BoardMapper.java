package board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import board.model.BoardVo;
//CREATE TABLE TBL_BOARD(
//SEQ NUMBER,
//WRITER VARCHAR2(30),
//CONTENTS VARCHAR2(200),
//REGDATE DATE
//);
//
//CREATE SEQUENCE BOARD_SEQ;
public interface BoardMapper {

	@Insert("INSERT INTO tbl_board VALUES(board_seq.nextval, #{writer},#{contents},sysdate)")
	int insertBoard(BoardVo board);

	@Select("select /*+ INDEX_DESC(tbl_board tbl_board_seq_pk)*/ * from tbl_board")
	List<BoardVo> listBoard();

	@Delete("DELETE FROM tbl_board WHERE seq = #{seq}")
	int deleteBoard(int seq);

	@Select("SELECT * FROM tbl_board where seq = #{seq}")
	BoardVo detailBoard(int seq);

	@Update("UPDATE tbl_board SET writer = #{writer}, contents = #{contents}, regdate = sysdate WHERE seq = #{seq}")
	int updateBoard(BoardVo board);

}
