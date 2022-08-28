package com.poc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.request.dto.EmployeeProfessionRequestDto;
import com.poc.response.dto.EmployeeProfessionResponseDto;
import com.poc.response.dto.PocResponse;
import com.poc.service.EmployeeProfessionService;
import com.poc.utility.ConstantsPoc;
import com.poc.utility.ResponseHelper;

/**
 * @author Nahid Sheikh
 * @since 26-August-2022
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/v1/api/employee-profession")
public class EmployeeProfessionController {

	@Autowired
	private EmployeeProfessionService employeeProfessionService;

	@PostMapping()
	@SuppressWarnings("unchecked")
	public PocResponse<EmployeeProfessionResponseDto> createEmployeeProfession(
			@Valid @RequestBody EmployeeProfessionRequestDto request) {
		EmployeeProfessionResponseDto response = employeeProfessionService.createEmployeeProfession(request);
		return ResponseHelper.createResponse(new PocResponse<EmployeeProfessionResponseDto>(), response,
				ConstantsPoc.EMPLOYEE_PROFESSION_CREATE_SUCCESS, ConstantsPoc.EMPLOYEE_PROFESSION_CREATE_FAIL);
	}

	@GetMapping("/active/all")
	@SuppressWarnings("unchecked")
	public PocResponse<List<EmployeeProfessionResponseDto>> getAllActiveEmployeeProfession() {
		List<EmployeeProfessionResponseDto> response = employeeProfessionService.getAllActiveEmployeeProfession();
		return ResponseHelper.createResponse(new PocResponse<List<EmployeeProfessionResponseDto>>(), response,
				ConstantsPoc.EMPLOYEE_PROFESSION_FETCH_SUCCESS, ConstantsPoc.EMPLOYEE_PROFESSION_FETCH_FAIL);
	}

}
