package domain;

import java.time.LocalDateTime;

public class Task {
	private int task_Id;// 할일아이디
	private LocalDateTime regdate;// 날짜
	private String contents; // 내용
	private int clear; // 수행여부
	private String mem_Id;

	public Task(int task_Id, LocalDateTime regdate, String contents, int clear, String mem_Id) {
		super();
		this.task_Id = task_Id;
		this.regdate = regdate;
		this.contents = contents;
		this.clear = clear;
		this.mem_Id = mem_Id;
	}

	public int getTask_Id() {
		return task_Id;
	}

	public void setTask_Id(int task_Id) {
		this.task_Id = task_Id;
	}

	public LocalDateTime getRegdate() {
		return regdate;
	}

	public void setRegdate(LocalDateTime regdate) {
		this.regdate = regdate;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public int getClear() {
		return clear;
	}

	public void setClear(int clear) {
		this.clear = clear;
	}

	public String getMem_Id() {
		return mem_Id;
	}

	public void setMem_Id(String mem_Id) {
		this.mem_Id = mem_Id;
	}
}
