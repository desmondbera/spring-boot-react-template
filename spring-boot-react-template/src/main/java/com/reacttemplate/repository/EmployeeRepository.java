package com.reacttemplate.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.reacttemplate.domain.Employee;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

}
