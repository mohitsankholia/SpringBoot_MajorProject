package com.dayone.service;

import java.util.List;

import com.dayone.entity.Department;

public interface DepartmentService {

	void saveDepartment(Department employee);
	
	void updateDepartment(Department employee);

	Department findDepartmentById(Integer id);
	
	void deleteDepartmentById(Integer id);
	
	List<Department> listOfDepartments();
	
	List<Department> findDepartmentByName(String name);

}
