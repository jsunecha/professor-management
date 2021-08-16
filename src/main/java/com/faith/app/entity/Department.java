package com.faith.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbldepartment")
public class Department {
		
	// data member
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "departmentid")
	private Integer departmentId;
	
	@Column(name = "departmentname",nullable = false, length=60)
	private String departmentName;
	
	//Default constructor
	public Department() {
		super();
	}
	
	//parameterized constructor
	public Department(Integer departmentId, String departmentName) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
	}
	
	//setters and getters
	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
}
