package project2023.Diploma_Projects_Management_App.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project2023.Diploma_Projects_Management_App.dao.ApplicationDAO;
import project2023.Diploma_Projects_Management_App.dao.StudentDAO;
import project2023.Diploma_Projects_Management_App.dao.SubjectDAO;
import project2023.Diploma_Projects_Management_App.model.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentRepository;
	@Autowired
	private SubjectDAO subjectRepository;
	@Autowired
	private ApplicationDAO applicationRepository;
	
	public StudentServiceImpl() {
		super();
	}

	@Autowired
	public StudentServiceImpl(StudentDAO theStudentRepository) {
		studentRepository = theStudentRepository;
	}
	
	@Override
	@Transactional
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	@Transactional
	public Student findById(int theId) {
		Student result = studentRepository.findById(theId);
				
		if (result != null ) {
			return result;
		}
		else {
			// we didn't find the student
			throw new RuntimeException("Did not find student id - " + theId);
		}
	}

	@Override
	@Transactional
	public void saveStudent(Student theStudent) {
		studentRepository.save(theStudent);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		studentRepository.deleteById(theId);
	}
	
	@Override
	@Transactional
	public Student findByIdAndAssignedFalse(int studentId){
		return studentRepository.findByIdAndAssignedFalse(studentId);
	}

}
