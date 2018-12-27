package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.domain.User;

@Controller
public class MemberController {
	// 透過 @RequestMapping 指定從/會被對應到此hello()方法
	// @Autowired
	// UserService userService;
	/*
	 * @RequestMapping("/user/{userId}") public String hello(@PathVariable("userId")
	 * int userId, Model model){ System.out.println("UserId = "+userId); String
	 * userName = userService.getName(userId); model.addAttribute("userName",
	 * userName); return "user"; }
	 */

	@Autowired
	UserRepository userRepository;

	@Autowired
	DataSource dataSource;

	@GetMapping("/memberPage")
	public String memberPage() {

		List<User> datas = new ArrayList<User>();
		datas = userRepository.findAll();

		for (int i = 0; i < datas.size(); i++) {
			System.out.println(datas.get(i).getId());
		}
		return "user";
	}

	@GetMapping("/login")
	public String login(@ModelAttribute User user) {

		return "login";
	}

	@PostMapping("/doLogin")
	public String doLogin(@ModelAttribute User user, Model model,HttpSession session) {
		List<User> users = userRepository.findCheckAccount(user.getEmail(), user.getPassword());
		String page = "login";
		if(session.getAttribute("uid")!=null)
			session.removeAttribute("uid");
		
		
		if (!users.isEmpty()) {
			page = "welcome";
			session.setAttribute("uid", users.get(0));
			model.addAttribute(users.get(0));
		}
		System.out.println("ss id = "+session.getId());
		return page;
	}

	@GetMapping("/addUser")
	public String addMemberPage(@ModelAttribute User user) {

		return "addUser";
	}

	@PostMapping("/doAddUser")
	public String doAddUser(@ModelAttribute User user) {
		// System.out.println(userRepository.findCheckMemberAccount(memberAccountJPA.getEmail(),
		// memberAccountJPA.getPassword()));
		user.setName("tesetName");
		System.out.println("user obj = " + user.toString());

		User useradd = userRepository.saveAndFlush(user);
		System.out.println("add obj = " + useradd.toString());

		return "addUser";
	}
}