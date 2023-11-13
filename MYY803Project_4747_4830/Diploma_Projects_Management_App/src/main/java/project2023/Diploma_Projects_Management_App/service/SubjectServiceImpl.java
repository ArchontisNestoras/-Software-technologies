package project2023.Diploma_Projects_Management_App.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project2023.Diploma_Projects_Management_App.dao.SubjectDAO;
import project2023.Diploma_Projects_Management_App.model.Subject;

@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectDAO subjectRepository;
	
	public SubjectServiceImpl() {
		super();
	}

	@Autowired
	public SubjectServiceImpl(SubjectDAO theSubjectRepository) {
		subjectRepository = theSubjectRepository;
	}
	
	@Override
	@Transactional
	public List<Subject> findAll() {
		return subjectRepository.findAll();
	}

	@Override
	@Transactional
	public Subject findById(int theId) {
		Subject result = subjectRepository.findById(theId);
				
		if (result != null ) {
			return result;
		}
		else {
			// we didn't find the subject
			throw new RuntimeException("Did not find subject id - " + theId);
		}
	}

	@Override
	@Transactional
	public void save(Subject theSubject) {
		subjectRepository.save(theSubject);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		subjectRepository.deleteById(theId);
	}
	
	@Override
	@Transactional
	public List<Subject> findNotAssignedSubjects() {
		return subjectRepository.findByAssignedFalse();
	}
	
	@Override
	@Transactional
	public List<Subject> findNotAssignedProfessorsSubjects(int professorId) {
		return subjectRepository.findBySupervisorAndAssignedFalse(professorId);
	}
}
