package com.dayone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dayone.entity.Department;

@Repository
public interface DepartmentRespository extends JpaRepository<Department, Integer>{
	
	List<Department> findByName(String name);

}
