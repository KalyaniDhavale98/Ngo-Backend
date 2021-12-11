package com.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.EmployeeDto;
import com.exception.DuplicateEmployeeException;
import com.exception.NoSuchEmployeeException;
import com.model.DonationDistribution;
import com.model.Employee;
import com.repository.AdminRepository;
import com.repository.EmployeeRepository;

@Service
public class AdminServiceImpl implements IAdminService {

	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	EmployeeRepository empRepository;
	
	@Override
	public Employee addEmployee(Employee employee) throws DuplicateEmployeeException, SQLException {
		int id = employee.getEmployeeId();
		if (id != 0) {
			throw new DuplicateEmployeeException();
		} else {
			Employee emp=new Employee();
			emp.setPhone(employee.getPhone());
			emp.setEmployeeName(employee.getEmployeeName());
			emp.setEmail(employee.getEmail());
			emp.setUsername(employee.getUsername());
			emp.setPassword(employee.getPassword());
			empRepository.save(employee);
		}
		return employee;
	}

	@Override
	public Employee modifyEmployee(int employeeId,Employee employee) throws Throwable {
		
		Optional<Employee> optional = empRepository.findById(employeeId);
		if(!optional.isPresent()) {
			throw new NoSuchEmployeeException("Employee Does not exist in the database");
		}
		Employee emp = optional.get();
		
		emp.setEmployeeName(employee.getEmployeeName());
		emp.setPhone(employee.getPhone());
		emp.setEmail(employee.getEmail());
	    emp.setUsername(emp.getUsername());
	    emp.setPassword(employee.getPassword());
	    
		return empRepository.save (emp);
	}
	// remove the employee data
	@Override
	public Employee removeEmployee(int employeeId,Employee employee) throws NoSuchEmployeeException {
		if (employeeId != 0)
			empRepository.deleteById(employeeId);

		else
			throw new NoSuchEmployeeException("Employee is not there in database");
		return employee;

	}

	// find employee by using id
	@Override
	public EmployeeDto findEmployeeById(int employeeId) throws NoSuchEmployeeException {
		
		Optional<Employee> employee = empRepository.findById(employeeId);
		if(!employee.isPresent()) {
			throw new NoSuchEmployeeException("Student not found with given employeeId "+employeeId);
		}
		
		Employee emp = employee.get();
		
		// Create dto obj
		EmployeeDto dto = new EmployeeDto();
		
		// update dto with employee details	
		dto.setEmployeeName(emp.getEmployeeName());
		dto.setEmail(emp.getEmail());
		dto.setPhone(emp.getPhone());
		dto.setUsername(emp.getUsername());
		dto.setPassword(emp.getPassword());
		return dto;

	}
	// find employee by using name
	@Override
	public Employee findEmployeeByName(String name) throws NoSuchEmployeeException {
		Employee e = empRepository.findByEmployeeName(name);
		return e;

	}

	// get all employees data
	@Override
	public List<Employee> getEmployees() {
		List<Employee> e = empRepository.findAll();

		return e;
	}

	@Override
	public boolean approveDonation(DonationDistribution distribution) {
		System.out.println("donation was approved");
		return false;
	}

}