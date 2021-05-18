package com.fintech.springapi.api.dao.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.fintech.springapi.api.dao.dto.CommonDto;

@RestController
@ControllerAdvice
public class MyException {
	
	@ExceptionHandler(value=IllegalArgumentException.class)
	public CommonDto<String> argumentException(IllegalArgumentException e) {
		return new CommonDto<>(HttpStatus.NO_CONTENT.value(), e.getMessage(), null);
	}
	
}
