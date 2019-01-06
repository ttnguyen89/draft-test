package com.example.demo.model;

import java.math.BigDecimal;

public class SalaryGraph {

	private BigDecimal salary;
	private String employeeName;
	
	public SalaryGraph(Employee employee) {
		this.salary = employee.getSalary();
		this.employeeName = employee.getFirstName() + " " + employee.getLastName();
	}
	public BigDecimal getSalary() {
		return salary;
	}
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
}
