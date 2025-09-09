package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImplentation 
		implements EmployeeService {
	@Autowired
	EmployeeRepository repo;

	@Override
	public void addEmployee(Employee emp) {
		repo.save(emp);
		
	}

	@Override
	public Employee searchEmployee(Long id) {		
		return repo.findById(id).get();
	}

	@Override
	public void updateEmployee(Employee emp) {
		repo.save(emp);
		
	}

	@Override
	public Employee getById(Long id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public void save(Employee existing) {
		repo.save(existing);
		
	}

	@Override
	public void deleteEmployee(Long id) {
		
	}

	@Override
	public void deleteById(int id) {
		repo.deleteById((long) id);
		
	}
	
	@Override
	public List<Employee> getAllEmployees() {
	    return repo.findAll();
	}

}
