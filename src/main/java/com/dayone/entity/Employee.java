package com.dayone.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="name",nullable = false,length = 200)
	private String name;
	
	@Column(name="designation",nullable = false,length = 200)
	private String Designation;
	
	private Integer age, salary, mob;
	
	private String email, address;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="department_id")
	private Department departmentId;

}
