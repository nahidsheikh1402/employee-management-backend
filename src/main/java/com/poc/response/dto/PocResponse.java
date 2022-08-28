package com.poc.response.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Nahid Sheikh
 * @since 26-August-2022
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PocResponse<T> {

	private T data;

	private String message;

	private boolean success;

	private String errorCode;

	private String path;

}
