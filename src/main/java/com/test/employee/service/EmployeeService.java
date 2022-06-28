package com.test.employee.service;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.employee.bean.Employee;

@Service
public class EmployeeService {
	Logger logger = LoggerFactory.getLogger(EmployeeService.class);
	@Autowired
	EmployeeDetails empDetials;

	public List<Employee> getAllEmployees(String order) throws ParseException {

		List<Employee> emp = empDetials.getAllEmployees();
		for (Employee emply : emp)
			logger.info("employees list before sorting : {}", emply.toString());

		if (order.equalsIgnoreCase("ASC")) {
			logger.info("Ascending order of employees");
			emp = emp.stream().sorted((o1, o2) -> o1.compareTo(o2)).collect(Collectors.toList());
		} else if (order.equalsIgnoreCase("DESC")) {
			logger.info("Descending order of employees");
			emp = emp.stream().sorted((o1, o2) -> o2.compareTo(o1)).collect(Collectors.toList());
		}
		return emp;
	}

	public Employee getEmpByID(int id) throws ParseException {
		List<Employee> emp = empDetials.getAllEmployees();
		return emp.stream().
		            filter(empl -> empl.getEmployeeID() ==  id)
		            .findFirst()
		            .orElse(null);

	}

}
