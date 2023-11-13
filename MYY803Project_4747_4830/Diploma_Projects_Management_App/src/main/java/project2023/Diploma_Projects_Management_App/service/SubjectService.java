package project2023.Diploma_Projects_Management_App.service;

import java.util.List;

import project2023.Diploma_Projects_Management_App.model.Subject;

public interface SubjectService {

	public List<Subject> findAll();
	
	public Subject findById(int theId);
	
	public void save(Subject theSubject);
	
	public void deleteById(int theId);
	
	public List<Subject> findNotAssignedSubjects();
	
	public List<Subject> findNotAssignedProfessorsSubjects(int professorId);
	
}
