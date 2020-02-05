package com.sg.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Amit
 *
 * 02-Feb-2020
 */

@Entity
@Table(name="follow")
public class Follow {
	@Id
	@Column(name="follow_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long followId;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date followTS; 
	
	@Column(name="user_id")
	private Long userId;
	
	//TODO mapping with user table
	private Long follwingUserId;
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	

	public Long getFollowId() {
		return followId;
	}

	public void setFollowId(Long followId) {
		this.followId = followId;
	}

	public Date getFollowTS() {
		return followTS;
	}

	public void setFollowTS(Date followTS) {
		this.followTS = followTS;
	}

	public Long getFollwingUserId() {
		return follwingUserId;
	}

	public void setFollwingUserId(Long follwingUserId) {
		this.follwingUserId = follwingUserId;
	}

	@Override
	public String toString() {
		return "Follow [followId=" + followId + ", followTS=" + followTS + ", follwingUserId=" + follwingUserId + "]";
	}
	
	
	

	/*foreign key
	 * userId
	*/
	
	
	
	
	

}
