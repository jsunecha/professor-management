package com.faith.app.dao;

import java.util.List;

import com.faith.app.entity.Professor;

public interface ProfessorDAO {
	
	//get all employees
	public List<Professor> findAll();
	
	//get a particular employee
	public Professor findById(int theId);
	
	// insert/update employee
	public void save(Professor theEmployee);
	
	//delete employee
	public void deleteById(int theId);
	
	
}
