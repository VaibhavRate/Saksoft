package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Employee;
import com.employee.repo.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	public Employee getEmployeeById(Long id) {
		return employeeRepository.findById(id).orElse(null);
	}

	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public Employee updateEmployee(Long id, Employee employee) {
		Employee existingEmployee = employeeRepository.findById(id).orElse(null);
		if (existingEmployee != null) {
			existingEmployee.setFirstName(employee.getFirstName());
			existingEmployee.setLastName(employee.getLastName());
			existingEmployee.setEmail(employee.getEmail());
			existingEmployee.setAge(employee.getAge());
			return employeeRepository.save(existingEmployee);
		}
		return null;
	}

	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
	}

}
