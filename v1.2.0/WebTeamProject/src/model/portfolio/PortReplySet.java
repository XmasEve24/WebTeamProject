package model.portfolio;

import java.util.ArrayList;

public class PortReplySet {
	
	// Portfolio 하나에 여러개의 댓글이 달리는 형태 
	private PortfolioVO port;
	private ArrayList<ReplyVO> reply = new ArrayList<ReplyVO>();
	
	public PortfolioVO getPort() {
		return port;
	}
	public void setPort(PortfolioVO port) {
		this.port = port;
	}
	public ArrayList<ReplyVO> getReply() {
		return reply;
	}
	public void setReply(ArrayList<ReplyVO> reply) {
		this.reply = reply;
	}
	
}
