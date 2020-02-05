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

@Entity
@Table(name="likes")

/**
 * @author Amit
 *
 * 02-Feb-2020
 */

public class Likes {
	
	@Id
	@Column(name="like_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long likeId;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date likeTimestamp;
	
	@Column(name="user_id")
	private Long userId;

	
public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	//	@OneToMany(cascade=CascadeType.ALL, mappedBy="post")
//	private List<Post> post;
	@Column(name="post_id")
	private Long postId;

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public Long getLikeId() {
		return likeId;
	}

	public void setLikeId(Long likeId) {
		this.likeId = likeId;
	}

	public Date getLikeTimestamp() {
		return likeTimestamp;
	}

	public void setLikeTimestamp(Date likeTimestamp) {
		this.likeTimestamp = likeTimestamp;
	}

	@Override
	public String toString() {
		return "Likes [likeId=" + likeId + ", likeTimestamp=" + likeTimestamp + ", postId=" + postId + "]";
	}

	
	
	/*foreign key
	 * userId
	 * postId
	*/
	

	

}
