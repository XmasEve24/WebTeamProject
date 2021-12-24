package controller;

public class ActionInformation {
	private boolean redirect; // 데이터 전송여부 
	private String path; // 페이지 정보 
	
	// .sendredirect T -> 전달할 정보가 없음
	// .forward F -> 전달할 정보 있음 
	
	public boolean isRedirect() {
		return redirect;
	}
	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
}
