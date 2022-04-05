package com.dayone.serviceImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.dayone.dto.EmployeeDTO;
import com.dayone.entity.Department;
import com.dayone.entity.Employee;
import com.dayone.repository.DepartmentRespository;
import com.dayone.repository.EmployeeRepository;
import com.dayone.service.EmployeeService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private DepartmentRespository departmentRespository;

	@Override
	public void saveEmployee(EmployeeDTO employeeDTO) throws Exception {
		
		Optional<Department> departmentOpt = departmentRespository.findById(employeeDTO.getDepartmentId());
		
		if(!departmentOpt.isPresent()) {
			throw new Exception("Department not available");
		}
		Employee employee= new Employee();
		employee.setName(employeeDTO.getName());
		employee.setDesignation(employeeDTO.getDesignation());
		employee.setDepartmentId(departmentOpt.get());
		employeeRepository.save(employee);

	}

	@Override
	public Employee findEmployeeById(Integer id) {

		return employeeRepository.findById(id).get();
	}

	@Override
	public void deleteEmployeeById(Integer id) {
		
		employeeRepository.deleteById(id); 
		
		
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeRepository.save(employee);
		
	}

	@Override
	public List<Employee> listOfEmployees() {
		
		return employeeRepository.findAll();
	}

	@Override
	public List<Employee> getAllEmployee() {

		return employeeRepository.getAll();
	}

	@Override
	public List<Employee> getEmployeeByName(String name) {
		
		return employeeRepository.getByName(name);
	}

	@Override
	public List<Employee> getEmployeeBySalary() {
		
		return employeeRepository.getBySalary();
	}

	@Override
	public List<Employee> getEmployeeByNameAndSalary(String name, Integer salary) {
		
		return employeeRepository.getByNameAndSalary(name, salary);
	}

	@Override
	public List<Employee> getEmployeeByNameStartingWith(String name) {
		
		return employeeRepository.getByNameStartingWith(name);
	}

	@Override
	public List<Employee> getEmployeeBySalaryBetween() {
	
		return employeeRepository.getBySalaryBetween();
	}

	@Override
	public List<Employee> getEmployeeBySalaryBetweenTwo(Integer startsalary, Integer endsalary) {
		
		return employeeRepository.getBySalaryBetweenTwo(startsalary, endsalary);
	}

	@Override
	public List<Employee> getEmployeeByNameAndAge(String name, Integer startage, Integer endage) {
		
		return employeeRepository.getByNameAndAge(name, startage, endage);
	}

	@Override
	public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
		
		String path = "C:\\Users\\Win10\\Downloads";
        List<Employee> employees = employeeRepository.findAll();
        //load file and compile it
        File file = ResourceUtils.getFile("classpath:Employee.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Mohit");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        if (reportFormat.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\employees.html");
        }
        if (reportFormat.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\employees.pdf");
        }
        if (reportFormat.equalsIgnoreCase("csv")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\employees.xlsx");
        }

        return "report generated in path : " + path;
	}
}

//	@Override
//	public List<Employee> findEmployeeByIdAndName(Integer id, String name) {
//		
//		return employeeRepository.findByIdAndName(id, name);
//	}
//
//	@Override
//	public List<Employee> findEmployeeByName(String name) {
//		
//		return employeeRepository.findByName(name);
//	}
//
//	@Override
//	public List<Employee> findEmployeeByNameStartingWithS(String name) {
//		
//		return employeeRepository.findByNameStartingWith(name);
//	}


