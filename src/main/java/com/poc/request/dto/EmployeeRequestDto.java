package com.poc.request.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.poc.utility.ConstantsPoc;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Nahid Sheikh
 * @since 26-August-2022
 *
 */
@Setter
@Getter
@ToString
public class EmployeeRequestDto {

	@NotBlank(message = ConstantsPoc.MANDOTORY_FIELD)
	private String name;

	@NotNull(message = ConstantsPoc.MANDOTORY_FIELD)
	@Min(value = 18, message = ConstantsPoc.MIN_AGE_PREFIX)
	@Max(value = 60, message = ConstantsPoc.MAX_AGE_PREFIX)
	private int age;

	@NotBlank(message = ConstantsPoc.MANDOTORY_FIELD)
	private String professionId;

}
