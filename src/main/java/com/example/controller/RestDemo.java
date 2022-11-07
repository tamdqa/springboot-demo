package com.example.controller;

import java.util.LinkedHashMap;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.repository.dto.TestArgsValid;
import com.example.service.impl.PersonService;

@RestController
@RequestMapping("/api/demo")
public class RestDemo {
	protected Logger logger = LogManager.getLogger(this.getClass());
	
	@Autowired
	PersonService personService;
	
	@PostMapping("/demoPost")
	public Object demoRest(@RequestBody @Valid TestArgsValid args) {
		logger.info("CALL API");
		return ResponseEntity.status(200).body("API call OK");
	}
	
	@GetMapping("/demoGet")
	public String testAPI (@RequestParam String text, @RequestParam Integer number, @RequestParam Boolean bool) {
		logger.info("CALL API");
		return "Hello!!!";
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/getAllData")
	public Object getAllData () {
		List<Document> datas = (List<Document>)personService.getListData(new LinkedHashMap<String, Object>());
		if (!datas.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).body(datas);
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("NO_CONTENT");
	}
}
