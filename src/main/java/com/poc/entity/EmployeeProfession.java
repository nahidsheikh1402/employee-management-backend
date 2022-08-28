package com.poc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.poc.utility.ConstantsPoc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
@Entity
@Table(name = "employee_profession")
public class EmployeeProfession extends BaseEntity {

	@NotBlank(message = ConstantsPoc.MANDOTORY_FIELD)
	@Column(name = "profession_name", unique = true)
	private String professionName;
}
