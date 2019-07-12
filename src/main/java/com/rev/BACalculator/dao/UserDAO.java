package com.rev.BACalculator.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rev.BACalculator.model.User;

public interface UserDAO extends JpaRepository<User, Integer>{
	
	@Query("select * from User u u.username = :username, u.password = :password")
	User login(@Param("username")String username, @Param("password")String password);
	
	@Query("insert into Users(userid_seq.nextval, firstname, lastname, username, password, email, bodyweight, gender) values (:firstname, :lastname, :username, :password, :email, :bodyweight, :gender)")
	User register(@Param("firstname")String firstname, @Param("lastname") String lastname, @Param("username") String username, @Param("password")String password, @Param("email")String email, @Param("bodyweight") double bodyweight, @Param("gender") String gender);
}
