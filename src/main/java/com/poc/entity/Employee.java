package com.poc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
@Entity
@Table(name = "employee")
public class Employee extends BaseEntity {

	@NotBlank(message = ConstantsPoc.MANDOTORY_FIELD)
	@Column(name = "name")
	private String name;

	@NotNull(message = ConstantsPoc.MANDOTORY_FIELD)
	@Min(value = 18, message = ConstantsPoc.MIN_AGE_PREFIX)
	@Max(value = 60, message = ConstantsPoc.MAX_AGE_PREFIX)
	@Column(name = "age")
	private int age;

	@NotNull(message = ConstantsPoc.MANDOTORY_FIELD)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "profession_id")
	private EmployeeProfession profession;

}
