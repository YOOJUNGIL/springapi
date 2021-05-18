package com.fintech.springapi.api.dao.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CommonDto<T> {
	private int resCode;
	private String resMsg;
	private T resData;
}
