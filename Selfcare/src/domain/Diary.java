package domain;

import java.time.LocalDateTime;

public class Diary {
	private int diary_Id;// 일기아이디
	private String content; // 내용
	private String mem_Id; // 맴버아이디
	private LocalDateTime regdate; // 날짜
	private int isRemoved;

	public int getIsRemoved() {
		return isRemoved;
	}

	public void setIsRemoved(int isRemoved) {
		this.isRemoved = isRemoved;
	}

	public Diary(int diary_Id, String content, String mem_Id, LocalDateTime regdate,int isRemoved) {
		super();
		this.diary_Id = diary_Id;
		this.content = content;
		this.mem_Id = mem_Id;
		this.regdate = regdate;
		this.isRemoved=isRemoved;
	}

	public Diary() {
		// TODO Auto-generated constructor stub
	}

	public int getDiary_Id() {
		return diary_Id;
	}

	public void setDiary_Id(int diary_Id) {
		this.diary_Id = diary_Id;
	}

	public String getMem_Id() {
		return mem_Id;
	}

	public void setMem_Id(String mem_Id) {
		this.mem_Id = mem_Id;
	}

	public LocalDateTime getRegdate() {
		return regdate;
	}

	public void setRegdate(LocalDateTime regdate) {
		this.regdate = regdate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
