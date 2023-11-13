package project2023.Diploma_Projects_Management_App.service;

import java.util.List;

import project2023.Diploma_Projects_Management_App.model.Student;

public interface StudentService {

	public List<Student> findAll();
	
	//public List<Student> findAllById(int studentId);
	
	public Student findById(int theId);
	
	public void saveStudent(Student theStudent);
	
	public void deleteById(int theId);
	
	public Student findByIdAndAssignedFalse(int studentId);
	
}
