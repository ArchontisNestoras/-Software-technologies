package project2023.Diploma_Projects_Management_App.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project2023.Diploma_Projects_Management_App.model.Student;
import project2023.Diploma_Projects_Management_App.model.Subject;

@Repository
public interface StudentDAO extends JpaRepository<Student, Integer> {
	
	public Student findById(int theId);
	
	//public List<Student> findAllById(int studentId);
	
	public Student findByIdAndAssignedFalse(int studentId);

}
