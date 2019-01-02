package com.example.demo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import org.springframework.web.context.WebApplicationContext;

import com.example.dao.UserRepository;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MockTest.class)
@WebAppConfiguration
//@Transactional //每次執行後 rollback數據
public class MockTest {
	
	@Autowired private WebApplicationContext webApplicationContext;
	MockMvc mvc; //創建MockMvc類的物件
	@Before
	public void setup(){
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void contextLoads() throws Exception {
		String uri = "/memberApi/1";
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON)).andReturn();
		int status = result.getResponse().getStatus();
		System.out.println("MockTest status = "+status);
		Assert.assertEquals("錯誤",200,status);
	}
}
