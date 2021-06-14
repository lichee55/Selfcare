package domain;

import java.time.LocalDateTime;

public class Task {
	private int task_Id;//���Ͼ��̵�
	private LocalDateTime regdate;//��¥
	private String contents;	//����
	private int clear;		//���࿩��
	
	public Task(int task_Id, LocalDateTime regdate, String contents, int clear) {
		super();
		this.task_Id = task_Id;
		this.regdate = regdate;
		this.contents = contents;
		this.clear = clear;
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
	
	
	
}
