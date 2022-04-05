package com.dayone.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dayone.entity.Department;
import com.dayone.repository.DepartmentRespository;
import com.dayone.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	private DepartmentRespository departmentRespository;

	@Override
	public void saveDepartment(Department employee) {
		departmentRespository.save(employee);
		
	}

	@Override
	public Department findDepartmentById(Integer id) {
		
		return departmentRespository.findById(id).get();
		
	}

	@Override
	public void deleteDepartmentById(Integer id) {
		
		departmentRespository.deleteById(id);
		
	}

	@Override
	public void updateDepartment(Department employee) {
		departmentRespository.save(employee);
		
	}

	@Override
	public List<Department> listOfDepartments() {
		
		return departmentRespository.findAll();
	}

	@Override
	public List<Department> findDepartmentByName(String name) {
		
		return departmentRespository.findByName(name);
	}
	
	

}
