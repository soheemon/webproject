package kosta.model;

public class Board {
	int seq;
	String writer,
			contents,
			regdate;
	
	public Board(){};
	
	public Board(int seq, String writer, String contents, String regdate) {
		super();
		this.seq = seq;
		this.writer = writer;
		this.contents = contents;
		this.regdate = regdate;
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
