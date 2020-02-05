package com.sg.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sg.beans.Likes;
import com.sg.beans.Post;

/**
 * @author Amit
 *
 * 02-Feb-2020
 */


@Repository
public interface LikesRepository extends JpaRepository<Likes, Long> {

	@Query(value = "SELECT post_id FROM likes l where l.userId = :userId",nativeQuery = true)
	List<Long> getAllLikedPost(@Param("userId")Long userId);
	
	@Query(value = "SELECT * FROM likes l where l.postId= :postId and l.userId = :userId",nativeQuery = true)
	Likes likeDislikePost(@Param("postId")Long postId,@Param("userId")Long userId);


}
