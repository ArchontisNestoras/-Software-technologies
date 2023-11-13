package project2023.Diploma_Projects_Management_App.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project2023.Diploma_Projects_Management_App.model.Professor;

@Repository
public interface ProfessorDAO extends JpaRepository<Professor, Integer> {
	
	public Professor findById(int theId);

}
