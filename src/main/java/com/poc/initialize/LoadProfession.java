package com.poc.initialize;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import com.poc.entity.EmployeeProfession;
import com.poc.repository.EmployeeProfessionRepository;

/**
 * @author Nahid Sheikh
 * @since 26-August-2022
 *
 */
@Configuration
@Order(1)
public class LoadProfession {
	private static final Logger log = LoggerFactory.getLogger(LoadProfession.class);

	@Bean
	CommandLineRunner iniRoleDatabase(EmployeeProfessionRepository employeeProfessionRepository) {
		return args -> {

			if (employeeProfessionRepository.count() > 0) {
				return;
			}
			log.info("Preloading " + employeeProfessionRepository.save(new EmployeeProfession("Manager")));
			log.info("Preloading " + employeeProfessionRepository.save(new EmployeeProfession("Engineer")));

		};
	}
}
