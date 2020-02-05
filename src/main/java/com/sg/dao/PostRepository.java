package com.sg.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sg.beans.Post;

/**
 * @author Amit
 *
 * 02-Feb-2020
 */


@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
	
	//@Query(value = "SELECT * FROM post where userId = :userId",nativeQuery = true)
	List<Post> findByUserId(@Param("userId") Long userId);
	

}
