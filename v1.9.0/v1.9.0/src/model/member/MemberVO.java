package model.member;

public class MemberVO {
	/*memberNum int primary key auto_increment,
    memberName varchar(20) not null,
    memberId varchar(20) not null,
    memberPw varchar(20) not null,
    memberEmail varchar(30) not null*/
	
	private int memberNum;
	private String memberName;
	private String memberId;
	private String memberPw;
	private String memberEmail;
	
	public int getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	
	
}
