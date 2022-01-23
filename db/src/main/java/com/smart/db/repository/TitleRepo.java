package com.smart.db.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.smart.db.entity.Title;
import com.smart.db.entity.TitleId;

public interface TitleRepo extends JpaRepository<Title, TitleId>{
}
