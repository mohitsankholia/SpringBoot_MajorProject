package com.dayone.controller;

import java.io.FileNotFoundException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dayone.dto.EmployeeDTO;
import com.dayone.entity.Employee;
import com.dayone.service.EmployeeService;
import com.dayone.utils.ApplicationUtils;

import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	private static Logger LOGGER = LogManager.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/save")
	public ResponseEntity<Object> saveEmployee(@RequestBody EmployeeDTO employeeDTO) throws Exception {
		
		LOGGER.info(ApplicationUtils.CLASSNAME + this.getClass().getSimpleName() + ", " + ApplicationUtils.METHODNAME
				+ "employeeService, " + ApplicationUtils.REQUESTPARAMETERS + employeeDTO.toString());
		
		employeeService.saveEmployee(employeeDTO);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/fetchbyid")
	public ResponseEntity<Object> findEmployeeById(@RequestParam Integer id) {
		
		LOGGER.info(ApplicationUtils.CLASSNAME + this.getClass().getSimpleName() + ", " + ApplicationUtils.METHODNAME
				+ "employeeService, " + ApplicationUtils.REQUESTPARAMETERS + id.toString());
		
		Employee employee = employeeService.findEmployeeById(id);
		return new ResponseEntity<>(employee,HttpStatus.OK);
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<Object> updateEmployee(@RequestBody Employee employee) {
		
		LOGGER.info(ApplicationUtils.CLASSNAME + this.getClass().getSimpleName() + ", " + ApplicationUtils.METHODNAME
				+ "employeeService, " + ApplicationUtils.REQUESTPARAMETERS + employee.toString());
		
		employeeService.updateEmployee(employee);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
	@DeleteMapping("/deletebyid")
	public ResponseEntity<Object> deleteEmployeeById(@RequestParam Integer id) {
		
		LOGGER.info(ApplicationUtils.CLASSNAME + this.getClass().getSimpleName() + ", " + ApplicationUtils.METHODNAME
				+ "employeeService, " + ApplicationUtils.REQUESTPARAMETERS + id.toString());
		
		employeeService.deleteEmployeeById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/fetchall")
	public ResponseEntity<Object> listOfEmployees() {
		
		LOGGER.info(ApplicationUtils.CLASSNAME + this.getClass().getSimpleName() + ", " + ApplicationUtils.METHODNAME
				+ "employeeService, ");
		
		List<Employee> employee = employeeService.listOfEmployees();
		return new ResponseEntity<>(employee,HttpStatus.OK);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<Object> getAllEmployee() {
		
		LOGGER.info(ApplicationUtils.CLASSNAME + this.getClass().getSimpleName() + ", " + ApplicationUtils.METHODNAME
				+ "employeeService, ");
		
		List<Employee> employee = employeeService.getAllEmployee();
		return new ResponseEntity<>(employee,HttpStatus.OK);
	}
	
	@GetMapping("/getbyname")
	public ResponseEntity<Object> getEmployeeByName(@RequestParam String name) {
		
		LOGGER.info(ApplicationUtils.CLASSNAME + this.getClass().getSimpleName() + ", " + ApplicationUtils.METHODNAME
				+ "employeeService, "+ ApplicationUtils.REQUESTPARAMETERS + name.toString());
		
		List<Employee> employee = employeeService.getEmployeeByName(name);
		return new ResponseEntity<>(employee,HttpStatus.OK);
	}
	
	@GetMapping("/getbysalary")
	public ResponseEntity<Object> getEmployeeBySalary (){
		
		LOGGER.info(ApplicationUtils.CLASSNAME + this.getClass().getSimpleName() + ", " + ApplicationUtils.METHODNAME
				+ "employeeService, ");
		
		List<Employee> employee = employeeService.getEmployeeBySalary();
		return new ResponseEntity<>(employee,HttpStatus.OK);
	}
	
	@GetMapping("/getbynameandsalary")
	public ResponseEntity<Object> getEmployeeByNameAnddSalary(@RequestParam String name, @RequestParam Integer salary) {
		
		LOGGER.info(ApplicationUtils.CLASSNAME + this.getClass().getSimpleName() + ", " + ApplicationUtils.METHODNAME
				+ "employeeService, "+ ApplicationUtils.REQUESTPARAMETERS + name.toString());
		
		List<Employee> employee = employeeService.getEmployeeByNameAndSalary(name, salary);
		return new ResponseEntity<>(employee,HttpStatus.OK);
	}
	
	@GetMapping("/getbynamestartingwith")
	public ResponseEntity<Object> getEmployeeByNameStaringWith(@RequestParam String name) {
		
		LOGGER.info(ApplicationUtils.CLASSNAME + this.getClass().getSimpleName() + ", " + ApplicationUtils.METHODNAME
				+ "employeeService, "+ ApplicationUtils.REQUESTPARAMETERS + name.toString());
		
		List<Employee> employee = employeeService.getEmployeeByNameStartingWith(name);
		return new ResponseEntity<>(employee,HttpStatus.OK);
	}
	
	@GetMapping("/getbysalarybetween")
	public ResponseEntity<Object> getEmployeeBySalaryBetween() {
		
		LOGGER.info(ApplicationUtils.CLASSNAME + this.getClass().getSimpleName() + ", " + ApplicationUtils.METHODNAME
				+ "employeeService, ");
		
		List<Employee> employee = employeeService.getEmployeeBySalaryBetween();
		return new ResponseEntity<>(employee,HttpStatus.OK);
	}
	
	@GetMapping("/getbysalarybetweentwo")
	public ResponseEntity<Object> getEmployeeBySalaryBetweenTwo(@RequestParam Integer startsalary, @RequestParam Integer endsalary) {
		
		LOGGER.info(ApplicationUtils.CLASSNAME + this.getClass().getSimpleName() + ", " + ApplicationUtils.METHODNAME
				+ "employeeService, ");
		
		List<Employee> employee = employeeService.getEmployeeBySalaryBetweenTwo(startsalary, endsalary);
		return new ResponseEntity<>(employee,HttpStatus.OK);
	}
	
	@GetMapping("/getbynameandage")
	public ResponseEntity<Object> getEmployeeByNameAndAge(@RequestParam String name, @RequestParam Integer startage, @RequestParam Integer endage) {
		
		LOGGER.info(ApplicationUtils.CLASSNAME + this.getClass().getSimpleName() + ", " + ApplicationUtils.METHODNAME
				+ "employeeService, "+ ApplicationUtils.REQUESTPARAMETERS + name.toString());
		
		List<Employee> employee = employeeService.getEmployeeByNameAndAge(name, startage, endage);
		return new ResponseEntity<>(employee,HttpStatus.OK); 
	}
	
	
//	@GetMapping("/fetchbyidandname")
//	public ResponseEntity<Object> findEmployeeByIdAndName(@RequestParam Integer id, @RequestParam String name) {
//		
//		LOGGER.info(ApplicationUtils.CLASSNAME + this.getClass().getSimpleName() + ", " + ApplicationUtils.METHODNAME
//				+ "employeeService, " + ApplicationUtils.REQUESTPARAMETERS + id.toString());
//		
//		List<Employee> department = employeeService.findEmployeeByIdAndName(id, name);
//		return new ResponseEntity<>(department,HttpStatus.OK);
//	}
//	
//	@GetMapping("/fetchbyname")
//	public ResponseEntity<Object> findEmployeeByName(@RequestParam String name) {
//		
//		LOGGER.info(ApplicationUtils.CLASSNAME + this.getClass().getSimpleName() + ", " + ApplicationUtils.METHODNAME
//				+ "employeeService, " + ApplicationUtils.REQUESTPARAMETERS + name.toString());
//		
//		List<Employee> department = employeeService.findEmployeeByName(name);
//		return new ResponseEntity<>(department,HttpStatus.OK);
//	}
//	
//	@GetMapping("/fetchbynamestartingwith")
//	public ResponseEntity<Object> findEmployeeByNameStartingWith(@RequestParam String name) {
//		
//		LOGGER.info(ApplicationUtils.CLASSNAME + this.getClass().getSimpleName() + ", " + ApplicationUtils.METHODNAME
//				+ "employeeService, " + ApplicationUtils.REQUESTPARAMETERS + name.toString());
//		
//		List<Employee> department = employeeService.findEmployeeByNameStartingWithS(name);
//		return new ResponseEntity<>(department,HttpStatus.OK);
//	}
	
	 @GetMapping("/report/{format}")
	    public ResponseEntity<Object> generateReport(@PathVariable String format) throws FileNotFoundException, JRException {
		 
		 LOGGER.info(ApplicationUtils.CLASSNAME + this.getClass().getSimpleName() + ", " + ApplicationUtils.METHODNAME
					+ "employeeService, "+ ApplicationUtils.REQUESTPARAMETERS + format.toString());
		 
//	        return employeeService.exportReport(format);
	        return ResponseEntity.ok(employeeService.exportReport(format));
	    }

}
