package com.poc.response.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Nahid Sheikh
 * @since 26-August-2022
 *
 */
@Setter
@Getter
@AllArgsConstructor
public class EmployeeProfessionResponseDto {

	private String id;

	private String professionName;

	private boolean active;

}
