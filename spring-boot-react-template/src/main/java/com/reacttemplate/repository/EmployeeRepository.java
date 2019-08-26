package com.reacttemplate.repository;

import org.springframework.data.repository.CrudRepository;

import com.reacttemplate.domain.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
