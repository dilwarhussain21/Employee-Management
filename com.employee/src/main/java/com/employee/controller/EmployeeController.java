package com.employee.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@GetMapping("/openAddEmployee")
	public String openAddEmployee() {
		return "addEmployee";
	}
	
	@PostMapping("/addEmployee")
	public String addEmployee(@ModelAttribute Employee emp, Model model) {
		service.addEmployee(emp);
		model.addAttribute("success", true);
		return "index";
	}
	
		
	@GetMapping("/openSearchEmployee")
	public String openSearchEmployee() {
		return "search";
	}
	
	@PostMapping("/searchEmployee")
	public String searchEmployee(@RequestParam Long id, Model m) {
		Employee emp = service.searchEmployee(id);
		m.addAttribute("emp", emp);
		
		m.addAttribute("success", true);
		return "showEmployee";
	}
	
	
	
	@GetMapping("/update")
    public String openUpdatePage() {
        return "update-employee";
    }
	
	@PostMapping("/updateEmployee")
    public String updateEmployee(@ModelAttribute Employee employee, Model model) {
        Employee existing = service.getById(employee.getId());
        if (existing != null) {
            existing.setName(employee.getName());
            existing.setDepartment(employee.getDepartment());
            existing.setSalary(employee.getSalary());
            existing.setCompany(employee.getCompany());
            service.save(existing);
            model.addAttribute("success", true);
        } else {
            model.addAttribute("error", "Employee not found!");
        }
        return "update-employee";
    }
	
	@GetMapping("/delete")
	public String openDeletePage() {
	    return "delete-employee";
	}

	// Handle Delete Request
	@PostMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam("id") int id, Model model) {
	    Employee existing = service.getById((long) id);
	    if (existing != null) {
	        service.deleteById(id);
	        model.addAttribute("success", true);
	    } else {
	        model.addAttribute("error", "Employee not found!");
	    }
	    return "delete-employee";
	}
	
	@GetMapping("/employees")
	public String getAllEmployees(Model model) {
	    List<Employee> employees = service.getAllEmployees();
	    model.addAttribute("employees", employees);
	    return "get-all-employees";
	}
}
