package com.poc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.poc.entity.Employee;
import com.poc.request.dto.EmployeeRequestDto;

/**
 * @author Nahid Sheikh
 * @since 26-August-2022
 *
 */
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface EmployeeMapper {

	public Employee requestToEntity(EmployeeRequestDto request);
}
