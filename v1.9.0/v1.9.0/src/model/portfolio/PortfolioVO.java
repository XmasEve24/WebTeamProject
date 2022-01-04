package model.portfolio;

import java.sql.Timestamp;

public class PortfolioVO {
	
	/*create table portfolio(
		    portNum int primary key auto_increment, 
		    adminNum int not null,
		    adminName varchar(20) not null,
		    portTitle varchar(50) not null,
		    portContent varchar(200),
		    portTime DateTime, 
		    constraint admin_fk foreign key(adminNum) references admin(adminNum) on DELETE CASCADE 
		);*/
	
	private int portNum;
	private int adminNum;
	private String adminName;
	
	private String portTitle;
	private String portContent;
	private Timestamp portTime;
	
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	
	public Timestamp getPortTime() {
		return portTime;
	}
	public void setPortTime(Timestamp portTime) {
		this.portTime = portTime;
	}
	public int getPortNum() {
		return portNum;
	}
	public void setPortNum(int portNum) {
		this.portNum = portNum;
	}
	public int getAdminNum() {
		return adminNum;
	}
	public void setAdminNum(int adminNum) {
		this.adminNum = adminNum;
	}
	public String getPortTitle() {
		return portTitle;
	}
	public void setPortTitle(String portTitle) {
		this.portTitle = portTitle;
	}
	public String getPortContent() {
		return portContent;
	}
	public void setPortContent(String portContent) {
		this.portContent = portContent;
	}
	
}
