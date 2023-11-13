package project2023.Diploma_Projects_Management_App.service;

import java.util.List;

import project2023.Diploma_Projects_Management_App.model.Thesis;

public interface ThesisService {

	public List<Thesis> findAll();
	
	public Thesis findById(int theId);
	
	public Thesis findByStudentid(int studentId);
	
	public void save(Thesis theThesis);
	
	public void deleteById(int theId);
	
}
