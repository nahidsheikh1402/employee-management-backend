package com.poc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.poc.entity.EmployeeProfession;
import com.poc.response.dto.EmployeeProfessionResponseDto;

/**
 * @author Nahid Sheikh
 * @since 26-August-2022
 *
 */
@Repository
public interface EmployeeProfessionRepository extends JpaRepository<EmployeeProfession, String> {

	public boolean existsByIdAndDeleted(String id, boolean deleted);

	@Query("SELECT new com.poc.response.dto.EmployeeProfessionResponseDto(ep.id, ep.professionName, ep.active) "
			+ "FROM #{#entityName} ep WHERE ep.active=true and ep.deleted=false")
	public List<EmployeeProfessionResponseDto> getAllActiveEmployeeProfession();

}
