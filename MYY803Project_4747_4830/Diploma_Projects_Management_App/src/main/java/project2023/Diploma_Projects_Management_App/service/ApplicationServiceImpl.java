package project2023.Diploma_Projects_Management_App.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project2023.Diploma_Projects_Management_App.dao.ApplicationDAO;
import project2023.Diploma_Projects_Management_App.model.Application;
import project2023.Diploma_Projects_Management_App.model.Subject;

@Service
public class ApplicationServiceImpl implements ApplicationService {

	@Autowired
	private ApplicationDAO applicationRepository;
	
	public ApplicationServiceImpl() {
		super();
	}

	@Autowired
	public ApplicationServiceImpl(ApplicationDAO theApplicationRepository) {
		applicationRepository = theApplicationRepository;
	}
	
	@Override
	@Transactional
	public List<Application> findAll() {
		return applicationRepository.findAll();
	}

	@Override
	@Transactional
	public Application findById(int theId) {
		Application result = applicationRepository.findById(theId);
				
		if (result != null ) {
			return result;
		}
		else {
			// we didn't find the application
			throw new RuntimeException("Did not find application id - " + theId);
		}
	}

	@Override
	@Transactional
	public void save(Application theApplication) {
		applicationRepository.save(theApplication);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		applicationRepository.deleteById(theId);
	}
	
	@Override
	@Transactional
	public List<Application> findBySubjectsid(List<Subject> subjectIds) {
		List<Application> applicationsAll = new ArrayList<Application>();
		for(int i=0; i<subjectIds.size(); i++) {
			List<Application> applications = applicationRepository.findBySubjectsid(subjectIds.get(i).getId());
			applicationsAll.addAll(applications);
		}
		return applicationsAll;
	}
	
	@Override
	@Transactional
	public List<Application> findByStudentid(int studentId){
		return applicationRepository.findByStudentid(studentId);
	}
	
	/*@Override
	public List<Application> findBySubjectsid(int subjectIds) {
		return applicationRepository.findBySubjectsid(subjectIds);
	}*/
	
	@Override
	@Transactional
	public List<Application> findBySubjectsidIn(List<Integer> subjects) {
		return applicationRepository.findBySubjectsidIn(subjects);
	}
	
	@Override
	@Transactional
	public void deleteByStudentid(int studentId) {
		applicationRepository.deleteByStudentid(studentId);
	}
}
