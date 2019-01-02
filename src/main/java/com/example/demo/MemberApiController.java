package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.UserRepository;
import com.example.domain.User;

@RestController
@RequestMapping("/memberApi")
public class MemberApiController {

	@Autowired
	UserRepository userRepository;
	@RequestMapping(value="/{id}")
	 public Optional<User> read(@PathVariable int id) {
		return userRepository.findById(id);
	 }
}
