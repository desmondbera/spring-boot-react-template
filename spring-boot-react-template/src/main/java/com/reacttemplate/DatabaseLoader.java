package com.reacttemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.reacttemplate.domain.Employee;
import com.reacttemplate.domain.Manager;
import com.reacttemplate.repository.EmployeeRepository;
import com.reacttemplate.repository.ManagerRepository;

@Component
public class DatabaseLoader implements CommandLineRunner {

	private final EmployeeRepository employees;
	private final ManagerRepository managers;
	
	@Autowired
	public DatabaseLoader(EmployeeRepository employeeRepository, ManagerRepository managerRepository) {
		this.employees = employeeRepository;
		this.managers = managerRepository;
	}
	
	@Override
	public void run(String... strings) throws Exception {
		
		Manager des = this.managers.save(new Manager("desmond", "beramendi", "ROLE_MANAGER" ));
		Manager jon = this.managers.save(new Manager("jon", "doe", "ROLE_MANAGER" ));

		SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken("jon", "doesn't mattter", AuthorityUtils.createAuthorityList("ROLE_MANAGER")));
		
		
		this.employees.save(new Employee("Desmond", "Beramendi", "Java Software Developer", jon));
		this.employees.save(new Employee("Bilbo", "Baggins", "burglar", jon));
		this.employees.save(new Employee("Gandalf", "the Grey", "wizard", jon));
		
		SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken("desmond", "doesn't m atter", AuthorityUtils.createAuthorityList("ROLE_MANAGER")));
		
		this.employees.save(new Employee("Samwise", "Gamgee", "gardener", des));
		this.employees.save(new Employee("Meriadoc", "Brandybuck", "pony rider", des));
		this.employees.save(new Employee("Peregrin", "Took", "pipe smoker", des));
		
		SecurityContextHolder.clearContext();
		
	}

}
