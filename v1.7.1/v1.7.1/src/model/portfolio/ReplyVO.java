package model.portfolio;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class ReplyVO {
	
	/*create table reply(
		    replyNum int primary key auto_increment,
		    portNum int not null,
		    replyContent varchar(50),
		    memberName varchar(20) not null,
		    replyTime DateTime,
		    constraint portfolio_fk foreign key(portNum) references portfolio(portNum) on DELETE CASCADE  
		);*/
	
	private int replyNum;
	private int portNum;
	private String replyContent;
	private String memberName;
	private Timestamp replyTime;
	
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
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public Timestamp getReplyTime() {
		return replyTime;
	}
	public void setReplyTime(Timestamp replyTime) {
		this.replyTime = replyTime;
	}
	
	
}
