package com.example.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.collection.DemoTable;

public interface MongoDemoRepository extends MongoRepository<DemoTable, String> {

	/**
	 * Like（模糊查詢） {"name" : name} ( name as regex)
	 */
	List<DemoTable> findByNameLike(String name);

	/**
	 * {"username" : name}
	 */
	List<DemoTable> findByName(String name);

	// {"Count" : {"$gt" : age}}
	List<DemoTable> findByCountGreaterThan(int count);

	/*
	 * save ：新增，如果有一个相同_ID，會覆蓋。
	 * 
	 * insert：新增，如果有一个相同_ID新增失败。
	 */
	public DemoTable save(DemoTable object);
	
	
	public void deleteByName(String name);

	//public void save(DemoTable object, String collectionName);
}
