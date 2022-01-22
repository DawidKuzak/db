package com.smart.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart.db.entity.WorksIn;
import com.smart.db.entity.WorksInId;

public interface WorksInRepo extends JpaRepository<WorksIn, WorksInId>{

//	List<WorksIn> findByEmp(Integer id);
//	List<WorksIn> findByDept(Character id);
}
