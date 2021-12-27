package model.admin;

public class AdminVO {
	
	/*adminNum int primary key auto_increment,
    adminName varchar(20) not null,
    adminId varchar(20) not null,
    adminPw varchar(20) not null,
    adminEmail varchar(30) not null*/
	
	private int adminNum;
	private String adminName;
	private String adminId;
	private String adminPw;
	private String adminEmail;
	
	public int getAdminNum() {
		return adminNum;
	}
	public void setAdminNum(int adminNum) {
		this.adminNum = adminNum;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getAdminPw() {
		return adminPw;
	}
	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	

}
