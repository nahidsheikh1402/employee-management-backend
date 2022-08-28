package com.poc.response.dto;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class EmployeeResponseDto {

	private String id;

	private String name;

	private int age;

	private String professionId;

	private String professionName;

	private boolean active;

}
