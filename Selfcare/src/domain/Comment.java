package domain;

import java.time.LocalDateTime;

public class Comment {
	private int comment_Id;//��� ���̵�
	private String contents;	//����
	private LocalDateTime regdate;//��¥
	private String writer;	//�ۼ���
	private int board_Id;	//�Խ��Ǿ��̵�
	
	public Comment(int comment_Id, String contents, LocalDateTime regdate, String writer, int boardId) {
		super();
		this.comment_Id = comment_Id;
		this.contents = contents;
		this.regdate = regdate;
		this.writer = writer;
		this.board_Id = board_Id;
	}
	public int getComment_Id() {
		return comment_Id;
	}
	public void setComment_Id(int comment_Id) {
		this.comment_Id = comment_Id;
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

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getBoard_Id() {
		return board_Id;
	}
	public void setBoard_Id(int board_Id) {
		this.board_Id = board_Id;
	}


}