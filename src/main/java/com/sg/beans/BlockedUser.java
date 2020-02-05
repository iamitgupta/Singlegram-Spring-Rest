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
/**
 * @author Amit
 *
 * 02-Feb-2020
 */


@Entity
@Table(name="blocked_User")
public class BlockedUser {
	
	@Id
	@Column(name="bloked_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long blokedId;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date followTS; 
	
	@Column(name="user_id")
	private Long userId;

	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	private Long blokedUserId;

	public Long getBlokedId() {
		return blokedId;
	}

	public void setBlokedId(Long blokedId) {
		this.blokedId = blokedId;
	}

	public Date getFollowTS() {
		return followTS;
	}

	public void setFollowTS(Date followTS) {
		this.followTS = followTS;
	}

	public Long getBlokedUserId() {
		return blokedUserId;
	}

	public void setBlokedUserId(Long blokedUserId) {
		this.blokedUserId = blokedUserId;
	}

	@Override
	public String toString() {
		return "BlockedUser [blokedId=" + blokedId + ", followTS=" + followTS + ", blokedUserId=" + blokedUserId + "]";
	}
	
	

}
