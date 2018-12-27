package com.example.demo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.service.UserService;
//for test
@Controller
public class userController {

	@Autowired
	UserService userService;

	@GetMapping("/")
	public String index(Map<String, Object> model) {
	 	model.put("ID", userService.getUserId());
		return "myfirstPage";
	}
}
