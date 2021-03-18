package com.ibm;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hr")
public class HrResource {

	public HrResource() {
		// TODO Auto-generated constructor stub
	}
	
	
	List<Employee> employees = Arrays.asList(
			new Employee("E1", "Ram", "Kumar", "MedTech"),
			new Employee("E2", "Raj", "Kumar", "Surgery"),
			new Employee("E3", "Anil", "Kumar", "Dentistry")
			);
	
	
	@RequestMapping("/employees")
	public EmployeeList getEmployees() {
		EmployeeList employeeList = new EmployeeList();
		
		employeeList.setEmployee(employees);
		return employeeList;
	}
	
	
	@RequestMapping("/employees/{Id}")
	public Employee getEmployeeById(@PathVariable("Id") String Id) {
		Employee e = employees.stream()
				.filter(employee -> Id.equals(employee.getId()))
				.findAny()
				.orElse(null);
		
		return e;
	}
	

}
