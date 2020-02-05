package com.sg.beans;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sun.istack.NotNull;

/**
 * @author Amit
 *
 * 02-Feb-2020
 */

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id")
	private Long userId;
	
	@NotNull
	private String password;
	
	@Column(unique=true)
	@NotNull
	private String email;
	
	@Column(unique=true)
	@NotNull
	private String username;
	
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	private String name;
	
	
	private String profileUrl;
	
	private Boolean privacyLevel;
	
	private Boolean isActive;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id",referencedColumnName = "user_id", insertable = false, updatable = false)
	//@JoinColumn(name="user_id",nullable=false)
	List<Post> postList;
	
	@OneToMany(cascade=CascadeType.ALL)
	//@JoinColumn(name="user_id",nullable=false)
	@JoinColumn(name="user_id",referencedColumnName = "user_id", insertable = false, updatable = false)
	List<Follow> followList;
	
	@OneToMany(cascade=CascadeType.ALL)
	//@JoinColumn(name="user_id",nullable=false)
	@JoinColumn(name="user_id",referencedColumnName = "user_id", insertable = false, updatable = false)
	List<BlockedUser> blockList;
	
	@OneToMany(cascade=CascadeType.ALL)
	//@JoinColumn(name="user_id",nullable=false)
	@JoinColumn(name="user_id",referencedColumnName = "user_id", insertable = false, updatable = false)
	List<Likes> postLikedList;
	
	@OneToMany(cascade=CascadeType.ALL)
	//@JoinColumn(name="user_id",nullable=false)
	@JoinColumn(name="user_id",referencedColumnName = "user_id", insertable = false, updatable = false)
	List<Comments> postCommentedList;


	public List<Comments> getPostCommentedList() {
		return postCommentedList;
	}

	public void setPostCommentedList(List<Comments> postCommentedList) {
		this.postCommentedList = postCommentedList;
	}

	public List<Likes> getPostLikedList() {
		return postLikedList;
	}

	public void setPostLikedList(List<Likes> postLikedList) {
		this.postLikedList = postLikedList;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getName() {
		return name;
	}

	public void setName(String fName) {
		this.name = fName;
	}

	
	public String getProfileUrl() {
		return profileUrl;
	}

	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}

	public Boolean getPrivacyLevel() {
		return privacyLevel;
	}

	public void setPrivacyLevel(Boolean privacyLevel) {
		this.privacyLevel = privacyLevel;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public List<Post> getPostList() {
		return postList;
	}

	public void setPostList(List<Post> postList) {
		this.postList = postList;
	}

	public List<Follow> getFollowList() {
		return followList;
	}

	public void setFollowList(List<Follow> followList) {
		this.followList = followList;
	}

	public List<BlockedUser> getBlockList() {
		return blockList;
	}

	public void setBlockList(List<BlockedUser> blockList) {
		this.blockList = blockList;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", email=" + email + ", username=" + username
				+ ", dob=" + dob + ", name=" + name + ", profileUrl=" + profileUrl + ", privacyLevel=" + privacyLevel
				+ ", isActive=" + isActive + ", postList=" + postList + ", followList=" + followList + ", blockList="
				+ blockList + ", postLikedList=" + postLikedList + "]";
	}

	
	
	
	
	
//	@OneToMany(cascade=CascadeType.ALL)
//	@JoinColumn(name="user_id",nullable=false)
//	List<Media> mediaList;
	
	
	

}
