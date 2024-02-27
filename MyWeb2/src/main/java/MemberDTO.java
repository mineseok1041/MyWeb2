import java.sql.Date;

public class MemberDTO {
	private String id;
	private String pw;
	private String name;
	private String email;
	private Date joinDate;
	
	public MemberDTO() {
	}
	
	public MemberDTO(String id, String pw, String name, String email) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
	}
	
	public MemberDTO(String id, String pw, String name, String email, Date joinDate) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.joinDate = joinDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	
}