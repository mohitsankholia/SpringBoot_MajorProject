package com.dayone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dayone.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
//	List<Employee> findByName(String name);
//	
//	List<Employee> findByIdAndName(Integer id, String name);
//	
//	List<Employee> findByNameStartingWith(String name);
	
	
	
	@Query(value=" select * from Employee", nativeQuery=true)
	public List<Employee> getAll();
	
	@Query("select e from Employee e where e.name=?1")
	public List<Employee> getByName(String name);
	
	@Query("select e from Employee e where e.salary<=30000")
	public List<Employee> getBySalary();
	
	@Query("select e from Employee e where e.name=?1 and e.salary<=?2")
	public List<Employee> getByNameAndSalary(String name, Integer salary);
	
	@Query("select e from Employee e where e.name LIKE :name%")
	public List<Employee> getByNameStartingWith(String name);
	
	@Query("select e from Employee e where e.salary BETWEEN 30000 AND 50000")
	public List<Employee> getBySalaryBetween();
	
	@Query("select e from Employee e where e.salary BETWEEN :startsalary AND :endsalary")
	public List<Employee> getBySalaryBetweenTwo(Integer startsalary, Integer endsalary );
	
	@Query("select e from Employee e where e.name LIKE :name% and e.age BETWEEN :startage AND :endage")
	public List<Employee> getByNameAndAge(String name, Integer startage, Integer endage );


}