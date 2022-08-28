package com.poc.utility;

import com.poc.enums.ErrorCode;
import com.poc.exception.PocException;
import com.poc.response.dto.PocResponse;

/**
 * @author Nahid Sheikh
 * @since 26-August-2022
 *
 */
public class ResponseHelper {

	public static PocResponse createResponse(PocResponse response, Object data, String successMessage,
			String errorMessage) {
		if (data != null) {
			response.setSuccess(true);
			response.setData(data);
			response.setMessage(successMessage);
		} else {
			throw new PocException(ErrorCode.INTERNAL_SERVER_ERROR, errorMessage);
		}
		return response;
	}

	public static PocResponse createResponseForBoolean(PocResponse response, Boolean flag, String successMessage,
			String errorMessage) {
		if (flag) {
			response.setSuccess(flag);
			response.setMessage(successMessage);
		} else {
			throw new PocException(ErrorCode.INTERNAL_SERVER_ERROR, errorMessage);
		}
		return response;
	}

}
