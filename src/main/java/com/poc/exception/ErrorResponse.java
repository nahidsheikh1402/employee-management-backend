package com.poc.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Nahid Sheikh
 * @since 26-August-2022
 *
 */
@Getter
@Setter
public class ErrorResponse {
	private int errorCode;

	private String message;

	private Boolean success;

	private Object errorData;

}
