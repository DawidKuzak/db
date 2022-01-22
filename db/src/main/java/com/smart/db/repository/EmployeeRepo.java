package com.smart.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart.db.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
