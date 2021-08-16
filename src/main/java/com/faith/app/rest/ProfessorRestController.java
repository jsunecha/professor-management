package com.faith.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faith.app.entity.Professor;
import com.faith.app.service.ProfessorService;

@RestController
@RequestMapping("/api")
public class ProfessorRestController {
	
	//service
	private ProfessorService professorService;

	@Autowired
	public ProfessorRestController(ProfessorService professorService) {
		super();
		this.professorService = professorService;
	}
	
	
	//1
	// expose "/professors" and return list of professors
	// /api/professors
	@GetMapping("/professors")
	public List<Professor> findAll() {
		return professorService.findAll();
	}
	
	
	//2
	// add mapping for GET /professors/{professorId}
	@GetMapping("/professors/{professorId}")
	public Professor getprofessor(@PathVariable int professorId) {
		
		Professor theProfessor=professorService.findById(professorId);
		
		if(theProfessor==null) {
			throw new RuntimeException("professor id is not found - " + professorId);
		}
		
		return theProfessor;
	}
	
	
	//3
	// add mapping for POST /professors - add new professor
	@PostMapping("/professors")
	public Professor addprofessor(@RequestBody Professor theProfessor) {
		
		// also just in case users pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update

		theProfessor.setId(0);
		professorService.save(theProfessor);
		return theProfessor;
	}
	
	//4
	// add mapping for PUT /professors - update existing professor
	@PutMapping("/professors")
	public Professor updateprofessor(@RequestBody Professor theProfessor) {
		
		professorService.save(theProfessor);
		return theProfessor;
	}
	
	
	//5
	// add mapping for DELETE /professors/{professorId} - delete professor
	public String deleteprofessor(@PathVariable int professorId) {
		
		Professor theProfessor=professorService.findById(professorId);
		
		// throw exception if null
		if(theProfessor==null) {
			throw new RuntimeException("professor id is not found - " + professorId);
		}
		
		professorService.deleteById(professorId);
		
		return "Deleted professor id : " + professorId ;
	}
	
}
