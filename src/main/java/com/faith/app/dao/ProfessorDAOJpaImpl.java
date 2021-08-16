package com.faith.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.faith.app.entity.Professor;

@Repository
public class ProfessorDAOJpaImpl implements ProfessorDAO {

	//import
	private EntityManager entityManager;
	
	//dependency Injection
	@Autowired
	public ProfessorDAOJpaImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	
	//Listing all Professors
	@Override
	public List<Professor> findAll() {
		
		// create a query by using JPQL
		Query theQuery =entityManager.createQuery("from Professor");
		
		// execute query and get result list
		List<Professor> Professors =theQuery.getResultList();
		
		// return the result
		return Professors;
	}


	//find by id for particular Professor
	@Override
	public Professor findById(int theId) {
		
		// get Professor
		Professor theProfessor =entityManager.find(Professor.class, theId);
		
		// return Professor
		return theProfessor;
	}

	//Save Professor both Insert and Update
	@Override
	public void save(Professor theProfessor) {
	
		//Insert or Update the Professor
		Professor dbProfessor =entityManager.merge(theProfessor);
		
		// update with id from db.. ... 
		// so we can get generated id for save/insert
		theProfessor.setId(dbProfessor.getId());
		
	}

	//Delete Professor
	@Override
	public void deleteById(int theId) {
		
		// delete object with primary key
		Query theQuery =entityManager.createQuery("delete from Professor where id=:professorId");
		
		//set parameter value
		theQuery.setParameter("professorId", theId);
		theQuery.executeUpdate();
	
	}

}
