package com.example.exception;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.base.BaseRestService;
import com.example.repository.dto.ResponseObj;

@RestControllerAdvice
public class GlobalExceptionHandler extends BaseRestService {
	
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ResponseObj handlerMethodArgumentNotValidException(MissingServletRequestParameterException ex) {
		Map<String, Object> errorMap = new LinkedHashMap<String, Object>();
		errorMap.put(ex.getParameterName(), ex.getMessage());
		return new ResponseObj(6001, ex.getMessage());
//		return ResponseEntity.status(6001).body(errorMap);
	}
}
