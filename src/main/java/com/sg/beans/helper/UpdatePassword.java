package com.sg.beans.helper;

/**
 * @author Amit
 *
 * 02-Feb-2020
 */


public class UpdatePassword {
	private Long userId;
	private String oldPassword;
	private String newPassword;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	@Override
	public String toString() {
		return "UpdatePassword [userId=" + userId + ", oldPassword=" + oldPassword + ", newPassword=" + newPassword
				+ "]";
	}
	
	

}
