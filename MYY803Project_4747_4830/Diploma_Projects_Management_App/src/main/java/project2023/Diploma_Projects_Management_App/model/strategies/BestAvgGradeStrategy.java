package project2023.Diploma_Projects_Management_App.model.strategies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import project2023.Diploma_Projects_Management_App.model.Application;
import project2023.Diploma_Projects_Management_App.model.Student;
import project2023.Diploma_Projects_Management_App.model.Subject;
import project2023.Diploma_Projects_Management_App.service.StudentService;

public class BestAvgGradeStrategy extends TemplateStrategyAlgorithm{

	@Override
	public Student findBestApplicant(List<Student> possibleStudents, float gradeLimit, int courseLimit) {
		/*List<Integer> studentIdList=new ArrayList<Integer>();
		List<Student> studentList=new ArrayList<Student>();
		Student bestApplicant;
		for(int i=0;i<application.size();i++) {
			studentIdList.add(application.get(i).getStudent_id());
		}
		for(int i=0;i<studentIdList.size();i++) {
			studentList.add(studentService.findById(studentIdList.get(i)));
		}*/
		
		Student bestApplicant=new Student();
		bestApplicant=possibleStudents.get(0);
		for(int i=0;i<possibleStudents.size();i++) {
			if(possibleStudents.get(i).getCurrentaveragegrade()>bestApplicant.getCurrentaveragegrade()) {
				bestApplicant=possibleStudents.get(i);
			}
		}
		return bestApplicant;
	}

	@Override
	public int compareApplication(Application app1, Application app2) {
		// TODO Auto-generated method stub
		return 0;
	}

}
