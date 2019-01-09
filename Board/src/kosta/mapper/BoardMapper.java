package kosta.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kosta.model.Board;

public interface BoardMapper {

	@Insert("INSERT INTO sh_board VALUES(sh_board_seq.nextval, #{writer},#{contents},sysdate)")
	int insertBoard(Board board);
	
	@Select("SELECT * FROM sh_board order by seq desc")
	List<Board> listBoard();
	
	@Delete("DELETE FROM sh_board WHERE seq = #{seq}")
	int deleteBoard(int seq);
	
	@Select("SELECT * FROM sh_board where seq = #{seq}")
	Board detailBoard(int seq);
	
	@Update("UPDATE SH_BOARD SET writer = #{writer}, contents = #{contents}, regdate = sysdate WHERE seq = #{seq}")
	int updateBoard(Board board);
	
}
