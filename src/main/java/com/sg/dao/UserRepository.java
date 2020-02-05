package com.sg.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sg.beans.User;

/**
 * @author Amit
 *
 * 02-Feb-2020
 */


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	/*
	 * @Query("FROM User WHERE username = ?1") List<Author> findByUsername(String
	 * username);
	 * 
	 * @Query(value =
	 * "FROM User u WHERE u.email = :email and u.password = :password", nativeQuery
	 * = true) User userLoginEmail(@Param("email") String email, @Param("password")
	 * String password);
	 * 
	 */

	// register

	// update

	// search
//	@Query(value = "Select * FROM user u WHERE LOWER(u.username) = :username", nativeQuery = true)
	public User findByUsername(@Param("username") String username);

//	@Query(value = "Select * FROM user u WHERE LOWER(u.email) = :email", nativeQuery = true)
	public User findByEmail(@Param("email") String email);

//	@Query(value = "Select * FROM user u WHERE u.name LIKE %:name%", nativeQuery = true)
	public List<User> findByName(String name);

	// delete/deactivate
		//	DELETE
		//DEACTIATE --UPDATE

	// login

	@Query(value = "Select * FROM user u WHERE LOWER(u.email) = :email  and u.password = :password  and is_active = true", nativeQuery = true)
	User userLoginEmail(@Param("email") String email, @Param("password") String password);

	@Query(value = "Select * FROM user u WHERE LOWER(u.username) = :username  and u.password = :password  and is_active = true", nativeQuery = true)
	User userLoginUsername(@Param("username") String username, @Param("password") String password);

}
