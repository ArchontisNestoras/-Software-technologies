package project2023.Diploma_Projects_Management_App.model.strategies;

import java.util.HashMap;
import java.util.List;

import project2023.Diploma_Projects_Management_App.model.Application;
import project2023.Diploma_Projects_Management_App.model.Student;
import project2023.Diploma_Projects_Management_App.model.Subject;

public abstract class TemplateStrategyAlgorithm implements BestApplicantStrategy{
	
	public TemplateStrategyAlgorithm() {

	}

	//public abstract Student findBestApplicant(List<Application> application);
	public abstract Student findBestApplicant(List<Student> possibleStudents, float gradeLimit, int courseLimit);
	
	public abstract int compareApplication(Application app1,Application app2);
	
	
}
