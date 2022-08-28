package com.poc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.poc.request.dto.EmployeeProfessionRequestDto;
import com.poc.response.dto.EmployeeProfessionResponseDto;

/**
 * @author Nahid Sheikh
 * @since 26-August-2022
 *
 */
@Service
public interface EmployeeProfessionService {

	/**
	 * @param request
	 * @return
	 */
	public EmployeeProfessionResponseDto createEmployeeProfession(EmployeeProfessionRequestDto request);

	/**
	 * @param employeeProfessionId
	 * @return
	 */
	public List<EmployeeProfessionResponseDto> getAllActiveEmployeeProfession();

}
