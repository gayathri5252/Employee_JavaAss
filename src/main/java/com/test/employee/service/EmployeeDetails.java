package com.test.employee.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.test.employee.bean.Employee;

@Service
public class EmployeeDetails {
	Logger logger = LoggerFactory.getLogger(EmployeeService.class);
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

	public List<Employee> getAllEmployees() throws ParseException {
		List<Employee> emp = new ArrayList<Employee>();
		//creating list of 10 random employees
		Employee emp1 = new Employee("AAA", 101, sdf.parse("11-01-1995"));
		Employee emp2 = new Employee("BBB", 102, sdf.parse("12-09-1997"));
		Employee emp3 = new Employee("CCC", 103, sdf.parse("13-03-1996"));
		Employee emp4 = new Employee("DDD", 104, sdf.parse("14-10-1997"));
		Employee emp5 = new Employee("EEE", 105, sdf.parse("15-07-1994"));
		Employee emp6 = new Employee("FFF", 106, sdf.parse("16-02-1995"));
		Employee emp7 = new Employee("GGG", 107, sdf.parse("17-07-1996"));
		Employee emp8 = new Employee("HHH", 108, sdf.parse("18-05-1992"));
		Employee emp9 = new Employee("III", 109, sdf.parse("19-05-1996"));
		Employee emp10 = new Employee("JJJ", 110, sdf.parse("20-06-1991"));

		emp.add(emp1);emp.add(emp2);emp.add(emp3);emp.add(emp4);emp.add(emp5);
		emp.add(emp6);emp.add(emp7);emp.add(emp8);emp.add(emp9);emp.add(emp10);

		for (Employee emply : emp)
			logger.info("employees list before sorting : {}", emply.toString());
		return emp;

}
}
