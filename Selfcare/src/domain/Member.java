package domain;

public class Member {
	private String mem_Id;
	private String name;
	private String password;

	public Member(String mem_Id, String name, String password) {
		super();
		this.mem_Id = mem_Id;
		this.name = name;
		this.password = password;
	}

	public String getMem_Id() {
		return mem_Id;
	}

	public void setMem_Id(String mem_Id) {
		this.mem_Id = mem_Id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
