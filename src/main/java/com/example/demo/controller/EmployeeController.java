package com.example.demo.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeDTO;
import com.example.demo.repository.EmployeeRepository;

@Controller
@RequestMapping(path = "/employees") 
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping(path="")
	public @ResponseBody Iterable<EmployeeDTO> getAllEmployees(@RequestParam(value="firstName", defaultValue="", required=false) String firstName){
		Iterable<Employee> allEmployees = employeeRepository.findAll();
		List<EmployeeDTO> filteredEmployeeDTOs = new ArrayList<>();
		ModelMapper modelMapper = new ModelMapper();
		
		if(firstName != null && !firstName.isEmpty()) {
			List<Employee> employees = new ArrayList<Employee>();
			allEmployees.forEach(employees::add);
			List<Employee> filteredEmployees = employees.stream()
														.filter(employee -> employee.getFirstName().equals(firstName))
														.collect(Collectors.toList());
			
			filteredEmployees.stream().forEach(employee -> filteredEmployeeDTOs.add(modelMapper.map(employee, EmployeeDTO.class)));
		} else {
			allEmployees.forEach(employee -> filteredEmployeeDTOs.add(modelMapper.map(employee, EmployeeDTO.class)));
		}
		return filteredEmployeeDTOs;
	}
}
