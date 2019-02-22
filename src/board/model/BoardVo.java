package board.model;

public class BoardVo {
	int seq;
	String writer,
			title,
			contents,
			regdate;
	
	public BoardVo(){};
	

	public BoardVo(int seq, String writer, String title, String contents, String regdate) {
		this.seq = seq;
		this.writer = writer;
		this.title = title;
		this.contents = contents;
		this.regdate = regdate;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "Board [seq=" + seq + ", writer=" + writer + ", contents=" + contents + ", regdate=" + regdate + "]";
	}
	
	
}
