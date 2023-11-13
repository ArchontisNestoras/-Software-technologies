package project2023.Diploma_Projects_Management_App.service;

import java.util.List;

import project2023.Diploma_Projects_Management_App.model.Professor;

public interface ProfessorService {

	public List<Professor> findAll();
	
	public Professor findById(int theId);
	
	public void saveProfessor(Professor theProfessor);
	
	public void deleteById(int theId);
	
}
