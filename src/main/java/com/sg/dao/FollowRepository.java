package com.sg.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sg.beans.Follow;

/**
 * @author Amit
 *
 * 02-Feb-2020
 */


@Repository
public interface FollowRepository extends JpaRepository<Follow, Long> {
	
	@Query(value = "SELECT * FROM follow f where follwing_user_id= :follwingUserId and user_id = :userId",nativeQuery = true)
	Follow followUnfollowUser(@Param("userId")Long userId, @Param("follwingUserId")Long follwingUserId);
	
	List<Follow> findByUserId(@Param("userId")Long userId);

}
