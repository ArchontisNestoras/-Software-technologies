package project2023.Diploma_Projects_Management_App.model.strategies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import project2023.Diploma_Projects_Management_App.model.Application;
import project2023.Diploma_Projects_Management_App.model.Student;
import project2023.Diploma_Projects_Management_App.model.Subject;
import project2023.Diploma_Projects_Management_App.service.StudentService;

public class RandomStrategy extends TemplateStrategyAlgorithm{

	@Override
	public Student findBestApplicant(List<Student> possibleStudents, float gradeLimit, int courseLimit) {
		Student bestApplicant=new Student();
		Random random = new Random();
		int randomIntWithBound = random.nextInt(possibleStudents.size());
		
		bestApplicant=possibleStudents.get(randomIntWithBound);

		return bestApplicant;
	}
	@Override
	public int compareApplication(Application app1, Application app2) {
		// TODO Auto-generated method stub
		return 0;
	}
}
