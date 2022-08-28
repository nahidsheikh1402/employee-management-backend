package com.poc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.poc.entity.EmployeeProfession;
import com.poc.response.dto.EmployeeProfessionResponseDto;

/**
 * @author Nahid Sheikh
 * @since 26-August-2022
 *
 */
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface EmployeeProfessionMapper {

	public EmployeeProfessionResponseDto entityToResponse(EmployeeProfession employeeProfession);
}
