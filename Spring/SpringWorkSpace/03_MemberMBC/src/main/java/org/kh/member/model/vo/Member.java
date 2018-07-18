package org.kh.member.model.vo;

public class Member {
	private String userId;
	private String userPw;
	private String userName;
	private String phone;
	public Member() {
		super();
	}
	public Member(String userId, String userPw, String userName, String phone) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.phone = phone;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
