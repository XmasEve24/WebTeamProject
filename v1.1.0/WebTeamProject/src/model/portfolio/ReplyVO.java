package model.portfolio;

import java.text.SimpleDateFormat;

public class ReplyVO {
	/*replyNum int primary key auto_increment,
    portNum int not null,
    replyContent varchar(50),
    memberNum int not null,
    memberName varchar(20) not null,
    replyTime DateTime,
    constraint portfolio_fk foreign key(portNum) references portfolio(portNum) on DELETE CASCADE  */
	
	private int replyNum;
	private int portNum;
	private String replyContent;
	private int memberNum;
	private String memberName;
	private SimpleDateFormat replyTime;
	
	public int getReplyNum() {
		return replyNum;
	}
	public void setReplyNum(int replyNum) {
		this.replyNum = replyNum;
	}
	public int getPortNum() {
		return portNum;
	}
	public void setPortNum(int portNum) {
		this.portNum = portNum;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
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
	public SimpleDateFormat getReplyTime() {
		return replyTime;
	}
	public void setReplyTime(SimpleDateFormat replyTime) {
		this.replyTime = replyTime;
	}
	
}
