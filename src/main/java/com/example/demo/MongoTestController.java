package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.collection.DemoTable;
import com.example.dao.MongoDemoRepository;

@RestController
public class MongoTestController {

	@Autowired
	private MongoDemoRepository mongoDemoRepository;

	@RequestMapping("/mongoTest/{name}")
	public DemoTable mongoName(@PathVariable String name) {
		System.out.println("name is "+name);
		List<DemoTable> list = mongoDemoRepository.findByName(name);
		//List<DemoTable> list = mongoDemoRepository.findByCountGreaterThan(2);
		DemoTable demodata = null;
		if (list != null & list.size() > 0) {
			demodata = list.get(0);

		}
		System.out.println("demoData is "+demodata);
		return demodata;
	}
	@RequestMapping("/mongoTest/insert/{name}")
	public DemoTable insertMongoName(@PathVariable String name) {
		
		
		DemoTable demodata = new DemoTable() ;
		int random=(int)(Math.random()*1000);
		demodata.setName(name);
		System.out.println("name is "+demodata.getName());
		demodata.setCount(random);
		demodata.setEmail("controll@mail");
		mongoDemoRepository.save(demodata);
		System.out.println("demoData is "+demodata);
		return demodata;
	}
	@RequestMapping("/mongoTest/deleteByName/{name}")
	public String deleteById(@PathVariable String name) {
		
		
		mongoDemoRepository.deleteByName(name);
		//System.out.println("demoData is "+demodata);
		return "刪除成功";
	}
	
	
	
	//public void insert(DemoTable object, String collectionName);
}
