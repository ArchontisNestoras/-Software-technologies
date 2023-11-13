package project2023.Diploma_Projects_Management_App.service;

import java.util.List;

import project2023.Diploma_Projects_Management_App.model.Application;
import project2023.Diploma_Projects_Management_App.model.Subject;

public interface ApplicationService {

	public List<Application> findAll();
	
	public Application findById(int theId);
	
	public void save(Application theApplication);
	
	public void deleteById(int theId);
	public void deleteByStudentid(int studentId);
	
	//public List<Application> findBySubjectsid(int subjectIds);
	public List<Application> findBySubjectsid(List<Subject> subjectIds);
	
	public List<Application> findByStudentid(int studentId);
	
	public List<Application> findBySubjectsidIn(List<Integer> subjects);
	
}
