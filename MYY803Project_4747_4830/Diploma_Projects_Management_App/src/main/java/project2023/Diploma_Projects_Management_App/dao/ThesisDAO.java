package project2023.Diploma_Projects_Management_App.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project2023.Diploma_Projects_Management_App.model.Thesis;

@Repository
public interface ThesisDAO extends JpaRepository<Thesis, Integer> {
	
	public Thesis findById(int theId);
	
	public Thesis findByStudentid(int studentId);
		
}
