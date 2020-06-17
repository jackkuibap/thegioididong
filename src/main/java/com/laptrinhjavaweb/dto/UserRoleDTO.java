package com.laptrinhjavaweb.dto;

public class UserRoleDTO extends AbstractDTO {
	
	private Long userID;
	private Long roleID;
	
	public Long getUserID() {
		return userID;
	}
	public void setUserID(Long userID) {
		this.userID = userID;
	}
	public Long getRoleID() {
		return roleID;
	}
	public void setRoleID(Long roleID) {
		this.roleID = roleID;
	}
}
