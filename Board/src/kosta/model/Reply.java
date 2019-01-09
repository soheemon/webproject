package kosta.model;

public class Reply {
	private int b_seq, //글번호
				r_seq; //댓글번호
	private String writer,
					contents,
					date;
	
	public Reply(int b_seq, int r_seq, String writer, String contents, String date) {
		super();
		this.b_seq = b_seq;
		this.r_seq = r_seq;
		this.writer = writer;
		this.contents = contents;
		this.date = date;
	}
	public int getB_seq() {
		return b_seq;
	}
	public void setB_seq(int b_seq) {
		this.b_seq = b_seq;
	}
	public int getR_seq() {
		return r_seq;
	}
	public void setR_seq(int r_seq) {
		this.r_seq = r_seq;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Reply [b_seq=" + b_seq + ", r_seq=" + r_seq + ", writer=" + writer + ", contents=" + contents
				+ ", date=" + date + "]";
	}
	
}
