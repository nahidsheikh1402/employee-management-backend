package com.poc.exception;

import com.poc.enums.ErrorCode;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Nahid Sheikh
 *
 */
@Getter
@Setter
public class PocException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	private Integer errorCode;

	private String message;

	public PocException(String message) {
		super(message);
		this.message = message;
	}

	public PocException(Integer error, String message) {
		super(message);
		this.errorCode = error;
		this.message = message;
	}

	public PocException(Integer error, Exception ex) {
		super(ex);
		this.errorCode = error;
		this.message = ex.getMessage();
	}

	public PocException(Exception ex) {
		super(ex);
		this.message = ex.getMessage();
	}

	public PocException(ErrorCode errorCode, String message) {
		super(message);
		this.errorCode = errorCode.getCode();
		this.message = message;
	}

}
