package project2023.Diploma_Projects_Management_App.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project2023.Diploma_Projects_Management_App.dao.ThesisDAO;
import project2023.Diploma_Projects_Management_App.model.Thesis;

@Service
public class ThesisServiceImpl implements ThesisService {

	@Autowired
	private ThesisDAO thesisRepository;
	
	public ThesisServiceImpl() {
		super();
	}

	@Autowired
	public ThesisServiceImpl(ThesisDAO theThesisRepository) {
		thesisRepository = theThesisRepository;
	}
	
	@Override
	@Transactional
	public List<Thesis> findAll() {
		return thesisRepository.findAll();
	}

	@Override
	@Transactional
	public Thesis findById(int theId) {
		Thesis result = thesisRepository.findById(theId);
				
		if (result != null ) {
			return result;
		}
		else {
			// we didn't find the thesis
			throw new RuntimeException("Did not find thesis id - " + theId);
		}
	}
	
	@Override
	@Transactional
	public Thesis findByStudentid(int studentId) {
		return thesisRepository.findByStudentid(studentId);
	}

	@Override
	@Transactional
	public void save(Thesis theThesis) {
		thesisRepository.save(theThesis);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		thesisRepository.deleteById(theId);
	}
}