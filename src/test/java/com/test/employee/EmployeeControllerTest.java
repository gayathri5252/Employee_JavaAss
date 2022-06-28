package com.test.employee;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.test.employee.bean.Employee;
import com.test.employee.controller.EmployeeController;
import com.test.employee.manager.EmployeeManager;
import com.test.employee.service.EmployeeDetails;
import com.test.employee.service.EmployeeService;

@WebMvcTest
public class EmployeeControllerTest {

	@Autowired
	private MockMvc mock;

	@MockBean
	private EmployeeService empService;

	@MockBean
	private EmployeeManager empManager;

	@InjectMocks
	private EmployeeController empController;

	Employee emp1 = new Employee("ZZZ", 101, new Date());
	Employee emp2 = new Employee("XXX", 102, new Date());

	@Before
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		this.mock = MockMvcBuilders.standaloneSetup(empController).build();
	}

	@Test
	public void getAllEmployees_success() throws Exception {
		List<Employee> empList = new ArrayList<>();
		empList.add(emp1);
		empList.add(emp2);

		Mockito.when(empManager.getAllEmployees("ASC")).thenReturn(empList);

		mock.perform(MockMvcRequestBuilders.get("/employees").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

	}

	@Test
	public void getEmpById_success() throws Exception {

		Mockito.when(empService.getEmpByID(101)).thenReturn(emp1);

		mock.perform(MockMvcRequestBuilders.get("/empbyid/101").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

	}

}
