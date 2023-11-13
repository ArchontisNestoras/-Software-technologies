package project2023.Diploma_Projects_Management_App.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project2023.Diploma_Projects_Management_App.dao.ProfessorDAO;
import project2023.Diploma_Projects_Management_App.model.Professor;

@Service
public class ProfessorServiceImpl implements ProfessorService {

	@Autowired
	private ProfessorDAO professorRepository;
	
	public ProfessorServiceImpl() {
		super();
	}

	@Autowired
	public ProfessorServiceImpl(ProfessorDAO theProfessorRepository) {
		professorRepository = theProfessorRepository;
	}
	
	@Override
	@Transactional
	public List<Professor> findAll() {
		return professorRepository.findAll();
	}

	@Override
	@Transactional
	public Professor findById(int theId) {
		Professor result = professorRepository.findById(theId);
				
		if (result != null ) {
			return result;
		}
		else {
			// we didn't find the professor
			throw new RuntimeException("Did not find professor id - " + theId);
		}
	}

	@Override
	@Transactional
	public void saveProfessor(Professor theProfessor) {
		professorRepository.save(theProfessor);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		professorRepository.deleteById(theId);
	}
}
