package com.slokam.scriptone.dto;

import lombok.Data;

@Data
public class ErrorResponse {

	private Integer errorResponseCode;
	private String message;
}
