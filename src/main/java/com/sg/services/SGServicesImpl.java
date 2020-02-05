package com.sg.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sg.beans.Comments;
import com.sg.beans.Follow;
import com.sg.beans.Likes;
import com.sg.beans.Post;
import com.sg.beans.User;
import com.sg.beans.helper.UpdatePassword;
import com.sg.dao.CommentRepository;
import com.sg.dao.FollowRepository;
import com.sg.dao.LikesRepository;
import com.sg.dao.LocationRepository;
import com.sg.dao.PostRepository;
import com.sg.dao.UserRepository;

/**
 * @author Amit
 *
 *         02-Feb-2020
 */

@Service
public class SGServicesImpl implements SGServices {

	// get repository
	@Autowired
	private UserRepository userRepo;

	@Autowired
	private CommentRepository commentsRepo;

	@Autowired
	private LocationRepository locationRepo;

	@Autowired
	private LikesRepository likesRepo;

	// @Autowired
	// private MediaRepository mediaRepo;

	@Autowired
	private PostRepository postRepo;

	@Autowired
	private FollowRepository followRepo;

	@Override
	public User userLogin(String usernameOrEmail, String password) {
		if (usernameOrEmail.contains("@")) {
			return userRepo.userLoginEmail(usernameOrEmail, password);
		} else {
			return userRepo.userLoginUsername(usernameOrEmail, password);
		}

	}

	@Override
	public Optional<User> searchUserById(Long userId) {
		return userRepo.findById(userId);
	}

	@Override
	public User searchUserByUsername(String username) {
		return userRepo.findByUsername(username);
	}

	@Override
	public User searchUserByEmail(String email) {
		return userRepo.findByEmail(email);
	}

	@Override
	public List<User> searchUserByName(String name) {
		return userRepo.findByName(name);
	}

	@Override
	public List<User> getAllUser() {
		return userRepo.findAll();
	}

	@Override
	public User createUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public User updateUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public Boolean updatePassword(UpdatePassword updatePassword) {
		Optional<User> userList = userRepo.findById(updatePassword.getUserId());
		User user = userList.get();
		if (userList.isPresent()) {
			if (user.getPassword().equals(updatePassword.getOldPassword())) {
				user.setPassword(updatePassword.getNewPassword());
				userRepo.save(user);
				return true;
			}
		}
		return false;

	}

	@Override
	public Boolean activateDeactivateAccount(Long userId) {
		Optional<User> userList = userRepo.findById(userId);
		User user = userList.get();
		if (userList.isPresent()) {
			// true--active
			if (user.getIsActive()) {
				// deactivate
				user.setIsActive(false);
				userRepo.save(user);
				return true;
			} else {
				// activate
				user.setIsActive(true);
				userRepo.save(user);
				return true;

			}
		}
		return false;
	}

	@Override
	public Boolean deleteAccount(Long userId) {
		if (userRepo.findById(userId) != null) {
			userRepo.deleteById(userId);
			return true;
		}
		return false;

	}

	@Override
	public Post doPost(Post post) {
		post.setPostTimestramp(new java.sql.Timestamp(new java.util.Date().getTime()));
		return postRepo.save(post);
	}

	@Override
	public Boolean deletePost(Long postId) {
		if (postRepo.findById(postId) != null) {
			postRepo.deleteById(postId);
			return true;
		}
		return false;
	}

	@Override
	public Post getPost(Long postId) {

		Optional<Post> postList = postRepo.findById(postId);
		if (postList.isPresent()) {
			return postList.get();
		} else
			return null;
	}

	@Override
	public List<Post> getAllUserPost(Long userId) {
		return postRepo.findByUserId(userId);

		// 2nd logic
		// return userRepo.findById(userId).get().getPostList();

	}

	@Override
	public List<Post> getFollowingPost(Long userId) {
		List<Post> postList = new ArrayList<>();
		// get following user list and user for self post
		List<User> userList = getFollowing(userId);
		userList.add(searchUserById(userId).get());

		for (User user : userList) {
			postList.addAll(getAllUserPost(user.getUserId()));
		}

		// sorting by time stamp
		TreeSet<Long> idList = new TreeSet<>();
		for (Post post : postList) {
			idList.add(post.getPostId());
		}
		
		postList.clear();
		for (Long id : idList) {
			postList.add(getPost(id));
		}

		return postList;

	}

	@Override
	public List<Post> getAllPost() {
		return postRepo.findAll();
	}

	@Override
	public Boolean likeDislikePost(Long postId, Long userId) {
		Likes like = likesRepo.likeDislikePost(postId, userId);
		if (like != null) {
			likesRepo.deleteById(like.getLikeId());
			return false;

		} else {
			Likes likes = new Likes();
			likes.setUserId(userId);
			likes.setPostId(postId);
			likes.setLikeTimestamp(new java.sql.Timestamp(new java.util.Date().getTime()));
			likesRepo.save(likes);
			return true;
		}
	}

	@Override
	public List<Likes> getPostLikes(Long postId) {
		Optional<Post> post = postRepo.findById(postId);
		if (post.isPresent()) {
			return post.get().getLikeList();
		}
		return null;

		// 2nd method

	}

	@Override
	public Integer getLikeCount(Long postId) {
		return postRepo.findById(postId).get().getLikeList().size();
	}

	@Override
	public List<Post> getAllLikedPost(Long userId) {
		// List<Likes> postLiked = userRepo.findById(userId).get().getPostLikedList();
		List<Post> postList = new ArrayList<Post>();
		// for(Likes likes : postLiked) {
		// postList.add(postRepo.findById(likes.get))
		// }
		for (Long postId : likesRepo.getAllLikedPost(userId)) {
			postList.add(getPost(postId));
		}
		return postList;
	}

	@Override
	public Post doComment(Comments comments) {
		comments.setCommentTS(new java.sql.Timestamp(new java.util.Date().getTime()));
		if (commentsRepo.save(comments) != null) {
			return postRepo.findById(comments.getPostId()).get();
		} else
			return null;
	}

	@Override
	public Integer getCommentsCount(Long postId) {
		return postRepo.findById(postId).get().getCommentsList().size();
	}

	@Override
	public List<Comments> getComments(Long postId) {
		return commentsRepo.findByPostId(postId);
	}

	@Override
	public Post deleteComment(Long commentId) {
		Comments comment = commentsRepo.findById(commentId).get();
		if (comment != null) {
			commentsRepo.deleteById(commentId);
			return postRepo.findById(comment.getPostId()).get();
		}
		return null;

	}

	@Override
	public Boolean followUnfollowUser(Long userId, Long followingUserId) {
		Follow follow = followRepo.followUnfollowUser(userId, followingUserId);
		if (follow != null) {
			// unfollow
			followRepo.deleteById(follow.getFollowId());
			return false;

		} else {
			Follow follows = new Follow();
			follows.setUserId(userId);
			follows.setFollwingUserId(followingUserId);
			follows.setFollowTS(new java.sql.Timestamp(new java.util.Date().getTime()));
			followRepo.save(follows);
			return true;
		}
	}

	@Override
	public List<User> getFollower(Long userId) {
		List<Follow> followList = followRepo.findByUserId(userId);
		List<User> userList = new ArrayList<User>();
		for (Follow follow : followList) {
			userList.add(userRepo.findById(follow.getFollwingUserId()).get());
		}
		return userList;

	}

	@Override
	public List<User> getFollowing(Long userId) {
		List<Follow> followList = followRepo.findByUserId(userId);
		List<User> userList = new ArrayList<User>();
		for (Follow follow : followList) {
			userList.add(userRepo.findById(follow.getUserId()).get());
		}
		return userList;
	}
	// TODO blocked user...same as followuser

	// @Override
	// public List<Post> latestFirst(List<Post> postList) {
	// // TODO Auto-generated method stub
	// return null;
	// }

}
