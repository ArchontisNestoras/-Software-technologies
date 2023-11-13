package project2023.Diploma_Projects_Management_App.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project2023.Diploma_Projects_Management_App.model.Subject;

@Repository
public interface SubjectDAO extends JpaRepository<Subject, Integer> {
	
	public Subject findById(int theId);
	public List<Subject> findByAssignedFalse();
	public List<Subject> findBySupervisorAndAssignedFalse(int professorId);

}
