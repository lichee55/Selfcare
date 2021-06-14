package domain;

import java.time.LocalDateTime;

public class Comment {
	private int comment_Id;// 댓글 아이디
	private String contents; // 내용
	private LocalDateTime regdate;// 날짜
	private String mem_id; // 작성자
	private int board_Id; // 게시판아이디
	private int isRemoved; // 삭제여부

	public Comment(int comment_Id, String contents, LocalDateTime regdate, String writer, int board_Id, int isRemoved) {
		super();
		this.comment_Id = comment_Id;
		this.contents = contents;
		this.regdate = regdate;
		this.mem_id = writer;
		this.board_Id = board_Id;
		this.isRemoved = isRemoved;
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

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public int getBoard_Id() {
		return board_Id;
	}

	public void setBoard_Id(int board_Id) {
		this.board_Id = board_Id;
	}

	public int getIsRemoved() {
		return isRemoved;
	}

	public void setIsRemoved(int isRemoved) {
		this.isRemoved = isRemoved;
	}

	
}
