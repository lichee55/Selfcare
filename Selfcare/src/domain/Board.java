package domain;

import java.time.LocalDateTime;

public class Board {
	private int board_Id;	//�Խ��� ���̵�
	private String contents;	//����
	private LocalDateTime regdate;//��¥
	private String title;	//����
	private String writer;	//�ۼ���
	private String hit;		//��ȸ��
	
	public Board() {}
	
	public Board(int board_Id, String contents, LocalDateTime regdate, String title, String writer, String hit) {
		super();
		this.board_Id = board_Id;
		this.contents = contents;
		this.regdate = regdate;
		this.title = title;
		this.writer = writer;
		this.hit = hit;
	}
	
	public int getBoard_Id() {
		return board_Id;
	}
	public void setBoard_Id(int board_Id) {
		this.board_Id = board_Id;
	}	
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public LocalDateTime getRegdate() {
		return regdate;
	}
	public void setRegdate(LocalDateTime regdate) {
		this.regdate = regdate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getHit() {
		return hit;
	}
	public void setHit(String hit) {
		this.hit = hit;
	}
}
