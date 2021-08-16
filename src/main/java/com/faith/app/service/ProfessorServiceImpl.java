package com.faith.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faith.app.dao.ProfessorDAO;
import com.faith.app.entity.Professor;

@Service
public class ProfessorServiceImpl implements ProfessorService {

	private ProfessorDAO professorDAO;
		
	@Autowired
	public ProfessorServiceImpl(ProfessorDAO professorDAO) {
		super();
		this.professorDAO = professorDAO;
	}
	
	@Override
	@Transactional
	public List<Professor> findAll() {
		return professorDAO.findAll();

	}

	@Override
	@Transactional
	public Professor findById(int theId) {
		return professorDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Professor theProfessor) {
		professorDAO.save(theProfessor);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		professorDAO.deleteById(theId);
	}


}
