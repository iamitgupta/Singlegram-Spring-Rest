package com.sg.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sg.beans.Comments;
import com.sg.beans.Likes;
import com.sg.beans.Post;
import com.sg.beans.User;
import com.sg.beans.helper.Login;
import com.sg.beans.helper.UpdatePassword;
import com.sg.services.SGServices;

/**
 * @author Amit
 *
 *         02-Feb-2020
 */

@RestController
@RequestMapping("api/sg")
public class SGController {

	@Autowired
	private SGServices services;

	@GetMapping("/")
	public String home() {
		return "<h1>Singlegram</h1>";
	}

	// User
	// User registration
	@PostMapping("/createUser")
	public User createUser(@RequestBody User user) {
		return services.createUser(user);
	}

	// user update profile
	@PutMapping("/updateUser")
	public User updateUser(@RequestBody User user) {
		return services.updateUser(user);
	}

	// change password
	@PutMapping("/updatePassword")
	public Boolean updatePassword(@RequestBody UpdatePassword updatePassword) {
		return services.updatePassword(updatePassword);
	}

	// activate/deactivate user acc
	@GetMapping("/activateDeactivateAccount/{UserId}")
	public Boolean activateDeactivateAccount(@PathVariable("userId") final Long userId) {
		return services.activateDeactivateAccount(userId);
	}

	// delete user acc
	@DeleteMapping("/deleteAccount/{UserId}")
	public Boolean deleteAccount(@PathVariable("userId") final Long userId) {
		return services.deleteAccount(userId);
	}

	// search user by id
	@GetMapping("/findUserById/{userId}")
	public Optional<User> findUserById(@PathVariable("userId") final Long userId) {
		return services.searchUserById(userId);
	}

	// search user by username
	@GetMapping("/findUserByUsername/{username}")
	public User findUserByUsername(@PathVariable("username") final String username) {
		return services.searchUserByUsername(username);
	}

	// search user by name
	@GetMapping("/findUserByName/{name}")
	public List<User> findUserByname(@PathVariable("name") final String name) {
		return services.searchUserByName(name);
	}

	// get user list
	@GetMapping("/allUser")
	public List<User> getAllUser() {
		return services.getAllUser();
	}

	// user login with email and username
	@PostMapping("/userLogin")
	public User userLogin(@RequestBody Login login) {
		return services.userLogin(login.getUsernameOrEmail(), login.getPassword());
	}

	// TODO user login with email and OTP post java mail integration

	// Post

	// create post
	@PostMapping("/doPost")
	public Post doPost(@RequestBody Post post) {
		return services.doPost(post);
	}

	// delete post
	@DeleteMapping("/deletePost/{postId}")
	public Boolean deletePost(@PathVariable("postId") final Long postId) {
		return services.deletePost(postId);
	}

	// get post by postId
	@GetMapping("/getPostById/{postId}")
	public Post getPost(@PathVariable("postId") final Long postId) {
		return services.getPost(postId);
	}

	// get all users post by user id
	@GetMapping("/getAllUserPost/{userId}")
	public List<Post> getAllUserPost(@PathVariable("userId") final Long userId) {
		return services.getAllUserPost(userId);
	}

	// get following post
	@GetMapping("/getFollowingPost/{userId}")
	public List<Post> getFollowingPost(@PathVariable("userId") final Long userId) {
		return services.getFollowingPost(userId);
	}

	// getAllPost
	public List<Post> getAllPost() {
		return services.getAllPost();
	}

	// likes

	// like/dislike post
	@GetMapping("/likeDislikePost/{postId}/{userId}")
	public Boolean likeDislikePost(@PathVariable("postId") final Long postId,
			@PathVariable("userId") final Long userId) {
		return services.likeDislikePost(postId, userId);
	}

	// get post Likes
	@GetMapping("/getPostLikes/{postId}")
	public List<Likes> getPostLikes(@PathVariable("postId") final Long postId) {
		return services.getPostLikes(postId);
	}

	// get likes count
	@GetMapping("/getLikeCount/{postId}")
	public Integer getLikeCount(@PathVariable("postId") final Long postId) {
		return services.getLikeCount(postId);
	}

	// get all post liked by user
	@GetMapping("/getAllLikedPost/{userId}")
	public List<Post> getAllLikedPost(@PathVariable("userId") final Long userId) {
		return services.getAllLikedPost(userId);
	}

	// comments
	// get comments count on post
	@GetMapping("/getCommentsCount/{postId}")
	public Integer getCommentsCount(@PathVariable("postId") final Long postId) {
		return services.getCommentsCount(postId);
	}

	// do comment
	@PostMapping("/doComment")
	public Post doComment(@RequestBody Comments comments) {
		return services.doComment(comments);
	}

	// get all comments on post
	@GetMapping("/getComments/{postId}")
	public List<Comments> getComments(@PathVariable("postId") final Long postId) {
		return services.getComments(postId);
	}

	// delete comment
	@DeleteMapping("/deleteComment/{commentId}")
	public Post deleteComment(@PathVariable("commentId") final Long commentId) {
		return services.deleteComment(commentId);
	}

	// follow

	// follow/unfollow user
	@GetMapping("/followUnfollowUser/{userId}/{followingUserId}")
	public Boolean followUnfollowUser(@PathVariable("userId") final Long userId,
			@PathVariable("followingUserId") final Long followingUserId) {
		return services.followUnfollowUser(userId, followingUserId);
	}

	// get follower list
	@GetMapping("/getFollower/{userId}")
	public List<User> getFollower(@PathVariable("userId") final Long userId) {
		return services.getFollower(userId);
	}

	// get following list
	@GetMapping("/getFollowing/{userId}")
	public List<User> getFollowing(@PathVariable("userId") final Long userId) {
		return services.getFollowing(userId);
	}

}
