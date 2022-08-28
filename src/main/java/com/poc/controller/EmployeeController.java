package com.poc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poc.request.dto.EmployeeRequestDto;
import com.poc.response.dto.EmployeeResponseDto;
import com.poc.response.dto.PocResponse;
import com.poc.service.EmployeeService;
import com.poc.utility.ConstantsPoc;
import com.poc.utility.ResponseHelper;

/**
 * @author Nahid Sheikh
 * @since 26-August-2022
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/v1/api/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping()
	@SuppressWarnings("unchecked")
	public PocResponse<EmployeeResponseDto> createEmployee(@Valid @RequestBody EmployeeRequestDto request) {
		EmployeeResponseDto response = employeeService.createEmployee(request);
		return ResponseHelper.createResponse(new PocResponse<EmployeeResponseDto>(), response,
				ConstantsPoc.EMPLOYEE_CREATE_SUCCESS, ConstantsPoc.EMPLOYEE_CREATE_FAIL);
	}

	@GetMapping("/{employeeId}")
	@SuppressWarnings("unchecked")
	public PocResponse<EmployeeResponseDto> getEmployeeById(@PathVariable(value = "employeeId") String employeeId) {
		EmployeeResponseDto response = employeeService.getEmployeeById(employeeId);
		return ResponseHelper.createResponse(new PocResponse<EmployeeResponseDto>(), response,
				ConstantsPoc.EMPLOYEE_FETCH_SUCCESS, ConstantsPoc.EMPLOYEE_FETCH_FAIL);
	}

	@DeleteMapping("/{employeeId}")
	@SuppressWarnings("unchecked")
	public PocResponse<Boolean> deleteEmployeeById(@PathVariable(value = "employeeId") String employeeId) {
		boolean response = employeeService.deleteEmployeeById(employeeId);
		return ResponseHelper.createResponse(new PocResponse<Boolean>(), response,
				ConstantsPoc.EMPLOYEE_DELETED_SUCCESS, ConstantsPoc.EMPLOYEE_DELETED_FAIL);
	}

	@PutMapping("/{employeeId}")
	@SuppressWarnings("unchecked")
	public PocResponse<EmployeeResponseDto> updateEmployee(@PathVariable(value = "employeeId") String employeeId,
			@Valid @RequestBody EmployeeRequestDto request) {
		EmployeeResponseDto response = employeeService.updateEmployee(employeeId, request);
		return ResponseHelper.createResponse(new PocResponse<EmployeeResponseDto>(), response,
				ConstantsPoc.EMPLOYEE_UPDATE_SUCCESS, ConstantsPoc.EMPLOYEE_UPDATE_FAIL);
	}

	@GetMapping("/all")
	@SuppressWarnings("unchecked")
	public PocResponse<List<EmployeeResponseDto>> getAllEmployee(
			@RequestParam(value = "employeeId", required = false) String employeeId) {
		List<EmployeeResponseDto> response = employeeService.getAllEmployee(employeeId);
		return ResponseHelper.createResponse(new PocResponse<List<EmployeeResponseDto>>(), response,
				ConstantsPoc.EMPLOYEE_FETCH_SUCCESS, ConstantsPoc.EMPLOYEE_FETCH_FAIL);
	}

	@DeleteMapping("/delete")
	@SuppressWarnings("unchecked")
	public PocResponse<Boolean> deleteAllEmployee(@RequestParam(value = "employeeIdList") String[] employeeIdList) {
		boolean response = employeeService.deleteAllEmployee(employeeIdList);
		return ResponseHelper.createResponse(new PocResponse<Boolean>(), response,
				ConstantsPoc.EMPLOYEE_DELETED_SUCCESS, ConstantsPoc.EMPLOYEE_DELETED_FAIL);
	}

	@GetMapping("/selected")
	@SuppressWarnings("unchecked")
	public PocResponse<List<EmployeeResponseDto>> getEmployeeByIdList(
			@RequestParam(value = "employeeIdList") String[] employeeIdList) {
		List<EmployeeResponseDto> response = employeeService.getEmployeeByIdList(employeeIdList);
		return ResponseHelper.createResponse(new PocResponse<EmployeeResponseDto>(), response,
				ConstantsPoc.EMPLOYEE_FETCH_SUCCESS, ConstantsPoc.EMPLOYEE_FETCH_FAIL);
	}

}
