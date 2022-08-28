package com.poc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.poc.request.dto.EmployeeRequestDto;
import com.poc.response.dto.EmployeeResponseDto;

/**
 * @author Nahid Sheikh
 * @since 26-August-2022
 *
 */
@Service
public interface EmployeeService {

	/**
	 * @param request
	 * @return
	 */
	public EmployeeResponseDto createEmployee(EmployeeRequestDto request);

	/**
	 * @param employeeId
	 * @return
	 */
	public EmployeeResponseDto getEmployeeById(String employeeId);

	/**
	 * @param employeeId
	 * @return
	 */
	public Boolean deleteEmployeeById(String employeeId);

	/**
	 * @param employeeId
	 * @param request
	 * @return
	 */
	public EmployeeResponseDto updateEmployee(String employeeId, EmployeeRequestDto request);

	/**
	 * @return
	 */
	public List<EmployeeResponseDto> getAllEmployee(String employeeId);

	/**
	 * @param employeeIdList
	 * @return
	 */
	public Boolean deleteAllEmployee(String[] employeeIdList);

	/**
	 * @param employeeIdList
	 * @return
	 */
	public List<EmployeeResponseDto> getEmployeeByIdList(String[] employeeIdList);

}
