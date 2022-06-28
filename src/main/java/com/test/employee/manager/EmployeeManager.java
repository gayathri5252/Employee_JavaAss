package com.test.employee.manager;

import java.text.ParseException;
import java.util.List;

import javax.management.AttributeNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.test.employee.bean.Employee;
import com.test.employee.service.EmployeeService;

@Service
public class EmployeeManager {
	Logger logger = LoggerFactory.getLogger(EmployeeService.class);
	@Autowired
	EmployeeService empService;

	// calling service class
	public List<Employee> getAllEmployees(String order) throws ParseException {
		List<Employee> empList = empService.getAllEmployees(order);

		return empList;
	}

	public Employee getEmpByID(int id) throws Exception {
		Employee emply = empService.getEmpByID(id);
	return emply;	
	}
}
