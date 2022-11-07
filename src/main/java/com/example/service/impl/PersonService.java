package com.example.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.example.service.BaseService;

@Repository("person")
public class PersonService implements BaseService{
	@Autowired
	MongoTemplate mongoTemplate;
	
	@Override
	public Object getData(Map<String, Object> mapParams) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getListData(Map<String, Object> mapParams) {
		// test get all data
		List<Document> datas = mongoTemplate.getCollection("person").find().into(new ArrayList<Document>());
		if (!datas.isEmpty()) {
			return datas;
		}
		return null;
	}

}
