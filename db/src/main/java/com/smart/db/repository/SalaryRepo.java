package com.smart.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart.db.entity.Salary;
import com.smart.db.entity.SalaryId;

public interface SalaryRepo extends JpaRepository<Salary, SalaryId>{
//	List<Salary> findByEmp(Integer id);
}
