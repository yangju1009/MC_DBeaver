package 게시판정보;

public class BbsVO {
	int no;
	String title;
	String content;
	String writer;
	
	public void setNo(int no) {
		this.no = no;
	}
	public int getNo() {
		return no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	@Override
	public String toString() {
		return "Bbs 데이터>> [no=" + no + ", title=" + title + ", content=" + content + ", writer=" + writer + "]";
	}
	
	
}
