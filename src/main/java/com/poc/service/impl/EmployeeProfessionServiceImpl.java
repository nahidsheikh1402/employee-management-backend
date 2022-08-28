package com.poc.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.entity.EmployeeProfession;
import com.poc.enums.ErrorCode;
import com.poc.exception.PocException;
import com.poc.mapper.EmployeeProfessionMapper;
import com.poc.repository.EmployeeProfessionRepository;
import com.poc.request.dto.EmployeeProfessionRequestDto;
import com.poc.response.dto.EmployeeProfessionResponseDto;
import com.poc.service.EmployeeProfessionService;
import com.poc.utility.ConstantsPoc;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Nahid Sheikh
 * @since 26-August-2022
 *
 */
@Slf4j
@Service
public class EmployeeProfessionServiceImpl implements EmployeeProfessionService {

	@Autowired
	private EmployeeProfessionRepository employeeProfessionRepository;

	@Autowired
	private EmployeeProfessionMapper employeeProfessionMapper;

	/**
	 * To create employee profession
	 * 
	 * @param request
	 * @return
	 */
	@Transactional
	@Override
	public EmployeeProfessionResponseDto createEmployeeProfession(EmployeeProfessionRequestDto request) {
		try {
			EmployeeProfession employeeProfession = new EmployeeProfession();
			employeeProfession.setProfessionName(request.getProfessionName());
			employeeProfession = employeeProfessionRepository.save(employeeProfession);
			if (!StringUtils.isBlank(employeeProfession.getId()))
				log.info("Employee Profession created successfullly");
			return employeeProfessionMapper.entityToResponse(employeeProfession);
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			throw new PocException(ErrorCode.INTERNAL_SERVER_ERROR, ConstantsPoc.EMPLOYEE_PROFESSION_CREATE_FAIL);
		}
	}

	/**
	 * To fetch all active employee profession
	 * 
	 * @param employeeProfessionId
	 * @return
	 */
	@Override
	public List<EmployeeProfessionResponseDto> getAllActiveEmployeeProfession() {
		try {
			List<EmployeeProfessionResponseDto> response = employeeProfessionRepository
					.getAllActiveEmployeeProfession();
			return response;
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			throw new PocException(ErrorCode.INTERNAL_SERVER_ERROR, ConstantsPoc.EMPLOYEE_PROFESSION_FETCH_FAIL);
		}
	}

}
