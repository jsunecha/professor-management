package com.faith.app.service;

import java.util.List;

import com.faith.app.entity.Professor;

public interface ProfessorService {

		//get all employees
		public List<Professor> findAll();
		
		//get a particular employee
		public Professor findById(int theId);
		
		// insert/update employee
		public void save(Professor theProfessor);
		
		//delete employee
		public void deleteById(int theId);
}
