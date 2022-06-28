package com.test.employee.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.test.employee.bean.Employee;
import com.test.employee.exception.EmployeeIdNotFountException;
import com.test.employee.manager.EmployeeManager;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeManager empManager;

	// at runtime we need to give order either asc/desc (ignore case)
	@GetMapping(value = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Employee>> getAllEmployees() throws ParseException {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Sorting Order: ");
		String order = sc.nextLine();
		List<Employee> empList = empManager.getAllEmployees(order);
		return new ResponseEntity<>(empList, HttpStatus.OK);
	}

	// in requset body we can give order either asc/desc
	@GetMapping(value = "/employeesByOrder", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Employee>> getAllEmployeesByOrder(@RequestBody String order) throws ParseException {
		List<Employee> empList = empManager.getAllEmployees(order);
		return new ResponseEntity<>(empList, HttpStatus.OK);
	}

	@GetMapping(value = "/empbyid/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getAllEmployee(@PathVariable("id") int id) throws Exception {

		Employee employee = empManager.getEmpByID(id);
		if (employee == null) {
			throw new EmployeeIdNotFountException("Invalid employee id ");
		}
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
}
