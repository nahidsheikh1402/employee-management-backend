package com.poc.service.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.entity.Employee;
import com.poc.entity.EmployeeProfession;
import com.poc.enums.ErrorCode;
import com.poc.exception.PocException;
import com.poc.mapper.EmployeeMapper;
import com.poc.repository.EmployeeProfessionRepository;
import com.poc.repository.EmployeeRepository;
import com.poc.request.dto.EmployeeRequestDto;
import com.poc.response.dto.EmployeeResponseDto;
import com.poc.service.EmployeeService;
import com.poc.utility.ConstantsPoc;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Nahid Sheikh
 * @since 26-August-2022
 *
 */
@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

	private Long currentTime = new Date().getTime();

	@Autowired
	private EmployeeMapper employeeMapper;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private EmployeeProfessionRepository employeeProfessionRepository;

	/**
	 * To create employee
	 * 
	 * @param request
	 * @return
	 */
	@Transactional
	@Override
	public EmployeeResponseDto createEmployee(EmployeeRequestDto request) {

		if (!employeeProfessionRepository.existsByIdAndDeleted(request.getProfessionId(), false))
			throw new PocException(ErrorCode.NOT_FOUND, ConstantsPoc.PROFESSION_NOT_FOUND);

		try {
			Employee employee = employeeMapper.requestToEntity(request);
			EmployeeProfession employeeProfession = employeeProfessionRepository.getById(request.getProfessionId());
			employee.setProfession(employeeProfession);
			employee = employeeRepository.save(employee);
			if (!StringUtils.isBlank(employee.getId()))
				log.info("Employee created successfullly");
			return (!StringUtils.isBlank(employee.getId())) ? employeeRepository.getEmployeeById(employee.getId())
					: null;
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			throw new PocException(ErrorCode.INTERNAL_SERVER_ERROR, ConstantsPoc.EMPLOYEE_CREATE_FAIL);
		}
	}

	/**
	 * To fetch employee by id
	 * 
	 * @param employeeId
	 * @return
	 */
	@Override
	public EmployeeResponseDto getEmployeeById(String employeeId) {

		if (!employeeRepository.existsByIdAndDeleted(employeeId, false))
			throw new PocException(ErrorCode.NOT_FOUND, ConstantsPoc.EMPLOYEE_NOT_FOUND);

		try {
			EmployeeResponseDto response = employeeRepository.getEmployeeById(employeeId);
			return response;
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			throw new PocException(ErrorCode.INTERNAL_SERVER_ERROR, ConstantsPoc.EMPLOYEE_FETCH_FAIL);
		}
	}

	/**
	 * To delete employee by id
	 * 
	 * @param employeeId
	 * @return
	 */
	@Transactional
	@Override
	public Boolean deleteEmployeeById(String employeeId) {

		if (!employeeRepository.existsByIdAndDeleted(employeeId, false))
			throw new PocException(ErrorCode.NOT_FOUND, ConstantsPoc.EMPLOYEE_NOT_FOUND);

		try {
			Employee employee = employeeRepository.getById(employeeId);
			employee.setDeleted(true);
			employee.setModifiedAt(currentTime);
			employee = employeeRepository.save(employee);
			return employee.isDeleted() ? true : false;
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			throw new PocException(ErrorCode.INTERNAL_SERVER_ERROR, ConstantsPoc.EMPLOYEE_DELETED_FAIL);
		}
	}

	/**
	 * To update employee by id
	 * 
	 * @param employeeId
	 * @param request
	 * @return
	 */
	@Transactional
	@Override
	public EmployeeResponseDto updateEmployee(String employeeId, EmployeeRequestDto request) {

		if (!employeeRepository.existsByIdAndDeleted(employeeId, false))
			throw new PocException(ErrorCode.NOT_FOUND, ConstantsPoc.EMPLOYEE_NOT_FOUND);

		if (!employeeProfessionRepository.existsByIdAndDeleted(request.getProfessionId(), false))
			throw new PocException(ErrorCode.NOT_FOUND, ConstantsPoc.PROFESSION_NOT_FOUND);

		try {
			EmployeeProfession employeeProfession = employeeProfessionRepository.getById(request.getProfessionId());
			Employee employee = employeeRepository.getById(employeeId);
			employee.setName(request.getName());
			employee.setAge(request.getAge());
			employee.setProfession(employeeProfession);
			employee = employeeRepository.save(employee);
			if (!StringUtils.isBlank(employee.getId()))
				log.info("Employee updated successfullly");
			return (!StringUtils.isBlank(employee.getId())) ? employeeRepository.getEmployeeById(employee.getId())
					: null;
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			throw new PocException(ErrorCode.INTERNAL_SERVER_ERROR, ConstantsPoc.EMPLOYEE_UPDATE_FAIL);
		}
	}

	/**
	 * To fetch list of employee, without employee id its fetch all data of employee
	 * 
	 * @param employeeId
	 * @param request
	 * @return
	 */
	@Override
	public List<EmployeeResponseDto> getAllEmployee(String employeeId) {
		try {
			if (StringUtils.isBlank(employeeId))
				employeeId = null;
			List<EmployeeResponseDto> response = employeeRepository.getAllEmployee(employeeId);
			return response;
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			throw new PocException(ErrorCode.INTERNAL_SERVER_ERROR, ConstantsPoc.EMPLOYEE_FETCH_FAIL);
		}
	}

	/**
	 * To fetch list of employee, without employee id its fetch all data of employee
	 * 
	 * @param employeeId
	 * @param request
	 * @return
	 */
	@Override
	@Transactional
	public Boolean deleteAllEmployee(String[] employeeIdList) {

		if (!employeeRepository.existsByIdIn(Arrays.asList(employeeIdList)))
			throw new PocException(ErrorCode.NOT_FOUND, ConstantsPoc.EMPLOYEE_NOT_FOUND);

		try {
			List<String> employeeIdArray = Arrays.asList(employeeIdList);
			employeeIdArray.forEach((employeeId) -> {
				boolean isdelete = deleteEmployeeById(employeeId);
				if (!isdelete)
					return;
			});
			return true;
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			throw new PocException(ErrorCode.INTERNAL_SERVER_ERROR, ConstantsPoc.EMPLOYEE_DELETED_FAIL);
		}
	}

	/**
	 * To fetch list of employee by list of employee id
	 * 
	 * @param employeeId
	 * @param request
	 * @return
	 */
	@Override
	public List<EmployeeResponseDto> getEmployeeByIdList(String[] employeeIdList) {

		if (!employeeRepository.existsByIdIn(Arrays.asList(employeeIdList)))
			throw new PocException(ErrorCode.NOT_FOUND, ConstantsPoc.EMPLOYEE_NOT_FOUND);

		try {
			List<EmployeeResponseDto> response = employeeRepository.getEmployeeByIdList(Arrays.asList(employeeIdList));
			return response;
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			throw new PocException(ErrorCode.INTERNAL_SERVER_ERROR, ConstantsPoc.EMPLOYEE_FETCH_FAIL);
		}
	}

}
