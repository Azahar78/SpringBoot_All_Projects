package com.boot.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyErrorResponse {

	private String message;
	private String status;
	private Integer code;
	private LocalDateTime dateTime;
}
