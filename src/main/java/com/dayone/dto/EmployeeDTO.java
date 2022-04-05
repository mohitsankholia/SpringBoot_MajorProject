package com.dayone.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeDTO {
	
	private String name;
	private String designation;
	private Integer age, salary, mob;
	private String email, address;
	private Integer departmentId;
}
