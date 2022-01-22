package com.smart.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart.db.entity.DeptManager;
import com.smart.db.entity.DeptManagerId;

public interface DeptManagerRepo extends JpaRepository<DeptManager, DeptManagerId> {
//	List<DeptManager> findByEmp(Integer id);
//	List<DeptManager> findByDept(Character id);
}
