package com.employee.service;

import java.util.List;

import com.employee.entity.Employee;

public interface EmployeeService {
	void addEmployee(Employee emp);
	
	Employee searchEmployee(Long id);
	
	void updateEmployee(Employee emp);

	Employee getById(Long id);

	void save(Employee existing);

	
	
	void deleteEmployee(Long id);

	void deleteById(int id);
	
	List<Employee> getAllEmployees();

	Employee getEmployeeById(int id);

}
