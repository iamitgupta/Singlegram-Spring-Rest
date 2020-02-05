package com.sg.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sg.beans.Comments;

/**
 * @author Amit
 *
 * 02-Feb-2020
 */


@Repository
public interface CommentRepository extends JpaRepository<Comments, Long> {
	
	public List<Comments> findByPostId(@Param("postId")Long postId);

}
