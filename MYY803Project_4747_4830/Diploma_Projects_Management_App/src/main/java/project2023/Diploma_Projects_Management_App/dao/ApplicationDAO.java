package project2023.Diploma_Projects_Management_App.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project2023.Diploma_Projects_Management_App.model.Application;
import project2023.Diploma_Projects_Management_App.model.Subject;

@Repository
public interface ApplicationDAO extends JpaRepository<Application, Integer> {
	
	public Application findById(int theId);
	
	public List<Application> findBySubjectsid(int subjectId);
	//public Application findBySubjectsid(int subjectId);
	
	public List<Application> findBySubjectsidIn(List<Integer> subjectIds);
	
	public List<Application> findByStudentid(int studentId);
	
	public void deleteByStudentid(int studentId);

}
