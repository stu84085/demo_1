package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserDao;

@Service
public class UserService {
	@Autowired
	UserDao userDao;
  public Integer getUserId(){
	  System.out.println("進入了UserService的getUserId方法");
	  int userId=1;
	  return userId;
  }

public String getName(int userId) {
	// TODO Auto-generated method stub
		return userDao.getUserName(userId);
}
}
