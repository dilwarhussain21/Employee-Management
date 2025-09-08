package com.EmployeeMgmt.Management.service;

import com.EmployeeMgmt.Management.model.Employee;
import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployee();

    void save(Employee employee);

    Employee getById(Long id);

    void deleteById(Long ids);
}
