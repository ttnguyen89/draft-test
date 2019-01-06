package com.example.demo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;

@RepositoryRestResource(collectionResourceRel = "employee", path = "employee")

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

}