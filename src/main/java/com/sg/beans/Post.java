package com.sg.beans;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * @author Amit
 *
 * 02-Feb-2020
 */

@Entity
@Table(name="post")

public class Post {
	
	@Id
	@Column(name="post_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long postId;
	
	private String caption;
	
	@Column(name="user_id")
	private Long userId;
	
	@Column(name = "location_id")
	private Long locationId;

	
	public Long getLocationId() {
		return locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Transient
	private Integer likeCount;
	
	@Transient
	private Integer commentsCount;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date postTimestramp;
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "media_id")
//	private Media media;
	
	private String imageUrl;
	
	
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="post_id",referencedColumnName = "post_id", insertable = false, updatable = false)
	private List<Comments> commentsList;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="post_id",referencedColumnName = "post_id", insertable = false, updatable = false)
	private List<Likes> likeList;

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public Integer getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(Integer likeCount) {
		this.likeCount = likeCount;
	}

	public Integer getCommentsCount() {
		return commentsCount;
	}

	public void setCommentsCount(Integer commentsCount) {
		this.commentsCount = commentsCount;
	}

	public Date getPostTimestramp() {
		return postTimestramp;
	}

	public void setPostTimestramp(Date postTimestramp) {
		this.postTimestramp = postTimestramp;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public List<Comments> getCommentsList() {
		return commentsList;
	}

	public void setCommentsList(List<Comments> commentsList) {
		this.commentsList = commentsList;
	}

	public List<Likes> getLikeList() {
		return likeList;
	}

	public void setLikeList(List<Likes> likeList) {
		this.likeList = likeList;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", caption=" + caption + ", likeCount=" + likeCount + ", commentsCount="
				+ commentsCount + ", postTimestramp=" + postTimestramp + ", imageUrl=" + imageUrl + ", commentsList="
				+ commentsList + ", likeList=" + likeList + "]";
	}
	
	/*foreign key
	 * userId
	 * mediaId
	*/
	
	

}
