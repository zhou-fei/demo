package com.example.demo.model.vo;

import lombok.Data;

import com.example.demo.model.enumeration.ResponseEnum;

/**
 * @author Phil
 */
@Data
public class Response<T> {

	private Integer code;

	private String message;

	private T data;

	public Response(Integer code, String message, T data) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public Response(Integer code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public Response(Integer code) {
		super();
		this.code = code;
		this.message = message;
	}

	public Response(ResponseEnum responseEnum) {
		super();
		this.code = responseEnum.value();
		this.message = responseEnum.stringValue();
	}

	public Response(ResponseEnum responseEnum, T data) {
		super();
		this.code = responseEnum.value();
		this.message = responseEnum.stringValue();
		this.data = data;
	}
}
