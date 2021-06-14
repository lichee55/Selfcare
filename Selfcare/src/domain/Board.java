package domain;

import java.time.LocalDateTime;

public class Board {
	private int board_Id; // 게시판 아이디
	private String contents; // 내용
	private LocalDateTime regdate;// 날짜
	private String title; // 제목
	private String mem_id; // 작성자
	private String hit; // 조회수
	private int isRemoved; // 삭제여부

	public Board() {
	}

	public Board(int board_Id, String contents, LocalDateTime regdate, String title, String mem_id, String hit,
			int isRemoved) {
		super();
		this.board_Id = board_Id;
		this.contents = contents;
		this.regdate = regdate;
		this.title = title;
		this.mem_id = mem_id;
		this.hit = hit;
		this.isRemoved = isRemoved;
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

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getHit() {
		return hit;
	}

	public void setHit(String hit) {
		this.hit = hit;
	}

	public int getIsRemoved() {
		return isRemoved;
	}

	public void setIsRemoved(int isRemoved) {
		this.isRemoved = isRemoved;
	}
}
