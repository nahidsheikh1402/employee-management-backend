package com.poc.request.dto;

import javax.validation.constraints.NotBlank;

import com.poc.utility.ConstantsPoc;

import lombok.Getter;
import lombok.ToString;

/**
 * @author Nahid Sheikh
 * @since 26-August-2022
 *
 */
@Getter
@ToString
public class EmployeeProfessionRequestDto {

	@NotBlank(message = ConstantsPoc.MANDOTORY_FIELD)
	private String professionName;
}
