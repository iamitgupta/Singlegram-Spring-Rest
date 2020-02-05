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
@Table(name="comments")
public class Comments {
	@Id
	@Column(name="comment_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long commentId;
	
	private String comments;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date commentTS;
	
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


	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Date getCommentTS() {
		return commentTS;
	}

	public void setCommentTS(Date commentTS) {
		this.commentTS = commentTS;
	}

	
	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}
	
	@Override
	public String toString() {
		return "Comments [commentId=" + commentId + ", comments=" + comments + ", commentTS=" + commentTS + ", postId="
				+ postId + "]";
	}

	
	

	/*foreign key
	 * userId
	 * postId
	*/
	
	
	

}
