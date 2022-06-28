package com.test.employee.bean;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Employee implements  Comparable<Employee>{

	
	public Employee() {
	}

	private String name;
	private int employeeID;
	private Date dateOfBirth;
	
//if incase lombok doent work	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Employee(String name, int employeeID, Date dateOfBirth) {
		super();
		this.name = name;
		this.employeeID = employeeID;
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", employeeID=" + employeeID + ", dateOfBirth=" + dateOfBirth + "]";
	}

	@Override
	public int compareTo(Employee o) {
		 return getDateOfBirth().compareTo(o.getDateOfBirth());
	}

	public int compare(Employee o1, Employee o2) {
	      return o1.getDateOfBirth().compareTo(o2.getDateOfBirth());
	  }
	
	
}
