package com.example.repository.dto;

import lombok.Data;

@Data
public class ResponseObj {
	public ResponseObj(int i, String message) {
		this.code = i;
		this.messsage = message;
	}
	private int code;
	private String messsage;
}
