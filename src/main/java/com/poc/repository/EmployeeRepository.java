package com.poc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.poc.entity.Employee;
import com.poc.response.dto.EmployeeResponseDto;

/**
 * @author Nahid Sheikh
 * @since 24-August-2022
 *
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

	public boolean existsByIdAndDeleted(String id, boolean deleted);

	public boolean existsByIdIn(List<String> employeeId);

	@Query("SELECT new com.poc.response.dto.EmployeeResponseDto(e.id, e.name, e.age, e.profession.id, e.profession.professionName, e.active) "
			+ "FROM #{#entityName} e Where e.id=:employeeId and e.deleted=false")
	public EmployeeResponseDto getEmployeeById(String employeeId);

	@Query("SELECT new com.poc.response.dto.EmployeeResponseDto(e.id, e.name, e.age, e.profession.id, e.profession.professionName, e.active) "
			+ "FROM #{#entityName} e "
			+ "Where ( (cast(:employeeId as text) IS NULL) OR (e.id=:employeeId) ) "
			+ "and e.deleted=false")
	public List<EmployeeResponseDto> getAllEmployee(@Param("employeeId") String employeeId);

	@Query("SELECT new com.poc.response.dto.EmployeeResponseDto(e.id, e.name, e.age, e.profession.id, e.profession.professionName, e.active) "
			+ "FROM #{#entityName} e Where e.id IN :employeeIdList and e.deleted=false")
	public List<EmployeeResponseDto> getEmployeeByIdList(@Param("employeeIdList") List<String> employeeIdList);

}
