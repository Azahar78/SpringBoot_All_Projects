package com.boot.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyErrorResponse {

	private Date timeStamp;
	private String status;
	private String message;
	private Integer code;
	
}
