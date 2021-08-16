package com.faith.app.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tblprofessor")
public class Professor {
	
	//data members / properties/fields
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "professorid")
	private Integer id;
	
	@Column(name = "professorname",nullable = false,length=60)
	private String professorName;
	
	@Column(name = "designation",nullable = false,length=60)
	private String designation;
	
	@Column(name = "dateofjoining")
	private Date dateofjoining;
	
	//foreign Key
	//Many professors - one department
	
	@ManyToOne
	@JoinColumn(name = "departmentid")
	private Department department;
	
		
	// default constructor
	public Professor() {
		super();
	}

	// parameterized constructor
	public Professor(Integer id, String professorName, String designation, Date dateofjoining, Department department) {
		super();
		this.id = id;
		this.professorName = professorName;
		this.designation = designation;
		this.dateofjoining = dateofjoining;
		this.department = department;
	}
	
	
	public Professor(Integer id, String professorName, String designation) {
		this.id = id;
		this.professorName = professorName;
		this.designation = designation;
	}

	//setters and getters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getprofessorName() {
		return professorName;
	}

	public void setprofessorName(String professorName) {
		this.professorName = professorName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Date getDateofjoining() {
		return dateofjoining;
	}

	public void setDateofjoining(Date dateofjoining) {
		this.dateofjoining = dateofjoining;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	//Override toString
	@Override
	public String toString() {
		return "professor [id=" + id + ", professorName=" + professorName + ", designation=" + designation
				+ ", dateofjoining=" + dateofjoining + ", department=" + department + "]";
	}
	
	
	
	

}
