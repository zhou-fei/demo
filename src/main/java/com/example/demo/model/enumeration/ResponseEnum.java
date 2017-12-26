package com.example.demo.model.enumeration;

/**
 * @author Phil
 */
public enum ResponseEnum {

	// 执行失败
	FAILURE(0, "Failure"),
	// 执行成功
	SUCCESS(1, "Success");

	private final int code;
	private final String message;

	ResponseEnum(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int value() {
		return this.code;
	}

	public String stringValue() {
		return this.message;
	}

	public static ResponseEnum valueOf(int code) {
		for (ResponseEnum response : values()) {
			if (response.code == code) {
				return response;
			}
		}
        throw new IllegalArgumentException("No matching constant for [" + code + "]");
	}

}
