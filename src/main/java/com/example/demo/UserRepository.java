package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	List<User> findAll();
	
	List<User> findByName(String name);
	
	@Query(value="select id,email,password,name from user where email = ?1 and password = ?2 " ,nativeQuery = true)
	List<User> findCheckAccount(String email, String password);
}
