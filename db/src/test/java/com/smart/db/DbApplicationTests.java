package com.smart.db;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.jayway.jsonpath.internal.Path;
import com.smart.db.entity.Employee;
import com.smart.db.entity.Salary;
import com.smart.db.repository.DepartmentRepo;
import com.smart.db.repository.DeptManagerRepo;
import com.smart.db.repository.EmployeeRepo;
import com.smart.db.repository.SalaryRepo;
import com.smart.db.repository.WorksInRepo;

@SpringBootTest
class DbApplicationTests {

	@Autowired
	EmployeeRepo empRepo;
	@Autowired
	SalaryRepo salRepo;
	@Autowired
	DepartmentRepo deptRepo;
	@Autowired
	DeptManagerRepo deptMan;
	
	@Test
	void contextLoads() {
		var emps = empRepo.findAll();
		if (emps.size() > 0) {
			assertEquals(emps.get(0).getClass(), Employee.class);
		} else {
			assertTrue(true);
		}
	}

	@Test
	void checkSalaryConstraint() {
		var emps = empRepo.findAll();
		var sals = salRepo.findAll();

		if (sals.size() > 0) {
			assertTrue(emps.contains(sals.get(0).getEmployee()));
		} else {
			assertTrue(true);
		}
	}
	@Test
	void testEmployees(){
		var emps = empRepo.findAll();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String file = gson.toJson(emps);
		String shouldbe = "  {\n"
				+ "    \"emp_no\": 54322,\n"
				+ "    \"birth_date\": \"lip 2, 1949\",\n"
				+ "    \"hire_date\": \"lip 17, 1969\",\n"
				+ "    \"first_name\": \"Heather\",\n"
				+ "    \"last_name\": \"Jordan\"\n"
				+ "  },";
		if (emps.size()>0) {
			assertTrue(file.contains(shouldbe) );
		}else {
			assertTrue(true);
		}
	}
}
