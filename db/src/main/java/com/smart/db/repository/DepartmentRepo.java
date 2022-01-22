package com.smart.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart.db.entity.Department;

public interface DepartmentRepo extends JpaRepository<Department, Character>  {

}
