package com.example.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public String getUserName(int userId){
		System.out.println("EXCUTE  getUserName");
	    List<Map<String,Object>> list = jdbcTemplate.queryForList("select name from user where id=?", userId);
	    return list!=null && !list.isEmpty() ?(String) list.get(0).get("name"):"not user exist";
  }
}
