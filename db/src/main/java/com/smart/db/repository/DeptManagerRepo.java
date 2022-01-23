package com.smart.db.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.smart.db.entity.DeptManager;
import com.smart.db.entity.DeptManagerId;

public interface DeptManagerRepo extends JpaRepository<DeptManager, DeptManagerId> {

}
