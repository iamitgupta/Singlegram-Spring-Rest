package com.sg.services;

import java.util.List;
import java.util.Optional;

import com.sg.beans.Comments;
import com.sg.beans.Likes;
import com.sg.beans.Post;
import com.sg.beans.User;
import com.sg.beans.helper.UpdatePassword;

/**
 * @author Amit
 *
 * 02-Feb-2020
 */


public interface SGServices {
	
	//User service
	
	//user
	//login
	public User userLogin(String usernameOrEmail, String password);
	
	//searchUser
	public Optional<User> searchUserById(Long userId);
	public User searchUserByUsername(String username);
	public User searchUserByEmail(String email);
	public List<User> searchUserByName(String name);
	public List<User> getAllUser();
	
	//create and update
	public User createUser(User user);
	public User updateUser(User user);
	public Boolean updatePassword(UpdatePassword updatePassword);
	
	//delete deactivate
	public Boolean activateDeactivateAccount(Long userId);
	public Boolean deleteAccount(Long userId);
	
	
	//post
	public Post doPost(Post post);
	public Boolean deletePost(Long postId);
	public Post getPost(Long postId);
	public List<Post> getAllUserPost(Long userId);
	public List<Post> getAllPost();
	public List<Post> getFollowingPost(Long userId);
	
	
	//likes
	public Boolean likeDislikePost(Long postId, Long userId);
	public List<Likes> getPostLikes(Long postId);
	public Integer getLikeCount(Long postId);
	public List<Post> getAllLikedPost(Long userId);
	
	//comments
	public Integer getCommentsCount(Long postId);
	public Post  doComment(Comments comments);
	public List<Comments> getComments(Long postId);
	public Post deleteComment(Long commentId);
	
	//follow
	public Boolean followUnfollowUser(Long userId, Long followingUserId);
	public List<User> getFollower(Long userId);
	public List<User> getFollowing(Long userId);
	
	//TODO Block user section
	
	//BL
//	public List<Post> latestFirst(List<Post> postList);
	
	
	
	
	
	
	 

}
