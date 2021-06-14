package domain;

import java.time.LocalDateTime;

public class Diary {
	private int diary_Id;//�ϱ���̵�
	private int mem_Id;	//�ɹ����̵�
	private LocalDateTime regdate;	//��¥
	
	public Diary(int diary_Id, int mem_Id, LocalDateTime regdate) {
		super();
		this.diary_Id = diary_Id;
		this.mem_Id = mem_Id;
		this.regdate = regdate;
	}

	public int getDiary_Id() {
		return diary_Id;
	}

	public void setDiary_Id(int diary_Id) {
		this.diary_Id = diary_Id;
	}

	public int getMem_Id() {
		return mem_Id;
	}

	public void setMem_Id(int mem_Id) {
		this.mem_Id = mem_Id;
	}

	public LocalDateTime getRegdate() {
		return regdate;
	}

	public void setRegdate(LocalDateTime regdate) {
		this.regdate = regdate;
	}
	
}
