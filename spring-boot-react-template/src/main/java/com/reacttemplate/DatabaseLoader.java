package com.reacttemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.reacttemplate.domain.Employee;
import com.reacttemplate.repository.EmployeeRepository;

@Component
public class DatabaseLoader implements CommandLineRunner {

	private final EmployeeRepository repository;
	
	@Autowired
	public DatabaseLoader(EmployeeRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public void run(String... args) throws Exception {
		this.repository.save(new Employee("Desmond", "Beramendi", "Java Software Developer"));
	}

}
