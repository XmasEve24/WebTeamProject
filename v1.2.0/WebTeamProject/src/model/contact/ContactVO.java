package model.contact;

public class ContactVO {
	/*contactNum int primary key auto_increment,
    contactType varchar(30) not null,
    portNum int not null,
    memberNum int not null,
    contactContent varchar(250) not null,
    memberEmail varchar(30) not null*/
	
	private int contactNum;
	private String contactType;
	private int portNum;
	private int memberNum;
	private String contactContent;
	private String memberEmail;
	public int getContactNum() {
		return contactNum;
	}
	public void setContactNum(int contactNum) {
		this.contactNum = contactNum;
	}
	public String getContactType() {
		return contactType;
	}
	public void setContactType(String contactType) {
		this.contactType = contactType;
	}
	public int getPortNum() {
		return portNum;
	}
	public void setPortNum(int portNum) {
		this.portNum = portNum;
	}
	public int getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}
	public String getContactContent() {
		return contactContent;
	}
	public void setContactContent(String contactContent) {
		this.contactContent = contactContent;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	
	
}
