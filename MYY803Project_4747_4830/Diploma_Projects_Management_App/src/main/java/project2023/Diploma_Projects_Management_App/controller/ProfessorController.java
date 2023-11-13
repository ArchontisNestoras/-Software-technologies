package project2023.Diploma_Projects_Management_App.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import project2023.Diploma_Projects_Management_App.model.Application;
import project2023.Diploma_Projects_Management_App.model.Professor;
import project2023.Diploma_Projects_Management_App.model.Student;
import project2023.Diploma_Projects_Management_App.model.Subject;
import project2023.Diploma_Projects_Management_App.model.Thesis;
import project2023.Diploma_Projects_Management_App.model.User;
import project2023.Diploma_Projects_Management_App.model.strategies.BestApplicantStrategy;
import project2023.Diploma_Projects_Management_App.model.strategies.BestApplicantStrategyFactory;
import project2023.Diploma_Projects_Management_App.model.strategies.TemplateStrategyAlgorithm;
import project2023.Diploma_Projects_Management_App.service.ApplicationService;
import project2023.Diploma_Projects_Management_App.service.ProfessorService;
import project2023.Diploma_Projects_Management_App.service.StudentService;
import project2023.Diploma_Projects_Management_App.service.SubjectService;
import project2023.Diploma_Projects_Management_App.service.ThesisService;

@Controller
public class ProfessorController {

	@Autowired
	private ProfessorService professorService;
	@Autowired
	private SubjectService subjectService;
	@Autowired
	private ApplicationService applicationService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private ThesisService thesisService;
	
	private HashMap<Subject, List<Student>> map;
	private int flag;
	private Student myStudent;
	
	@RequestMapping("/professor/dashboard")
    public String getProfessorHome(){
        return "professor/dashboard";
    }
	
	@RequestMapping("/professor/dashboard/info")
	public String infoStudent(@AuthenticationPrincipal User user, Model theModel) {
		Professor theProfessor = professorService.findById(user.getId());
		theModel.addAttribute("professor", theProfessor);
		
		return "professor/pr_information";
	}
	
	@RequestMapping("/professor/dashboard/info/save")
	public String save(@ModelAttribute("professor") Professor theProfessor, Model theModel) {
		
		// save the employee
		professorService.saveProfessor(theProfessor);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/professor/dashboard";
	}
	
	@RequestMapping("/professor/dashboard/subjectList")
	public String listSubjects(@AuthenticationPrincipal User user, Model theModel) {
		
		// get employees from db
		List<Subject> theSubjects = subjectService.findNotAssignedProfessorsSubjects(user.getId());
		
		// add to the spring model
		theModel.addAttribute("subjects", theSubjects);
		
		/* Simple test this is how to get the 
		 * name of the person logged in to be used for other purposes 
		 * Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		 * String currentPrincipalName = authentication.getName();
		 * System.out.println(currentPrincipalName);
		*/
		
		return "professor/prof_subjectList";
	}
	
	@RequestMapping("/professor/dashboard/addSubject")
	public String addSubject(@AuthenticationPrincipal User user, Model theModel) {
		
		// create model attribute to bind form data
		Subject theSubject = new Subject(user.getId(), false);
		
		theModel.addAttribute("subject", theSubject);
		
		return "professor/subject-form";
	}
	
	@RequestMapping("/professor/dashboard/addSubject/save")
	public String saveSubject(@ModelAttribute("subject") Subject theSubject, Model theModel) {
		
		// save the employee
		subjectService.save(theSubject);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/professor/dashboard/subjectList";
	}
	
	@RequestMapping("/professor/dashboard/delete")
	public String deleteSubject(@RequestParam("subjectId") int theId) {
		
		// delete the employee
		subjectService.deleteById(theId);
		
		// redirect to /professor/dashboard/subjectList
		return "redirect:/professor/dashboard/subjectList";
		
	}
	
	@RequestMapping("/professor/dashboard/applicationList")
	public String listApplications(@AuthenticationPrincipal User user, Model theModel) {

		if(flag == 0 && myStudent == null){
			flag = 2;
		}
		theModel.addAttribute("message", flag);
		theModel.addAttribute("myStudent", myStudent);
		flag = 2;

		List<Subject> theSubjects = subjectService.findNotAssignedProfessorsSubjects(user.getId());
		List<Application> theApplications = applicationService.findBySubjectsid(theSubjects);
		for(int i = 0; i<theApplications.size(); i++) {
			System.out.println(theApplications.get(i).getId());
		}

		map = new HashMap<Subject, List<Student>>();
		
		Subject lastSubject = new Subject();
		List<Student> value = new ArrayList<Student>();
		for(int i=0; i<theApplications.size(); i++) {
			Subject applicationSubject = subjectService.findById(theApplications.get(i).getSubjects_id());
	
			Student applicationStudent = studentService.findByIdAndAssignedFalse(theApplications.get(i).getStudent_id());
			System.out.println(applicationStudent);
			
			if(lastSubject.equals(applicationSubject) || i==0) {
				value.add(applicationStudent);
			}else {
				value = new ArrayList<Student>();
				value.add(applicationStudent);
			}

			map.put(applicationSubject, value);
			
			lastSubject = applicationSubject;
		}
		
		for (Subject name: map.keySet()) {
		    String key = name.toString();
		    String valueee = map.get(name).toString();
		    System.out.println(key + " " + valueee);
		}

		theModel.addAttribute("specificMap", map);
		
		HashMap<String, List<String>> mapForHtml = new HashMap<String, List<String>>();
		for (Subject key : map.keySet()) {
			List<String> values = new ArrayList<String>();
			for (Student v : map.get(key)) {
				values.add(v.getFullname());
			}
			mapForHtml.put(key.getTitle(), values);
		}

		theModel.addAttribute("mapForHtml", mapForHtml);
		
		return "professor/prof_applicationList";
		
	}
	
	@RequestMapping("/professor/dashboard/applicationList/assign")
	public String assignStrategy(@AuthenticationPrincipal User user, @RequestParam("subjectId") int subjectId, @RequestParam("dropdownMenu") String option, @RequestParam(value="gradeLimit", defaultValue="0") float gradeLimit, @RequestParam(value="courseLimit", defaultValue="0") int courseLimit) {

		List<Student> possibleStudents = new ArrayList<Student>();
		for (Subject key : map.keySet()) {
			if(key.getId() == subjectId) {
				possibleStudents = map.get(key);
			}
		}
		
		for(int i=0; i<possibleStudents.size(); i++) {
			if(possibleStudents.get(i).getYearsofstudies()!=null || possibleStudents.get(i).getCurrentaveragegrade()!=null || possibleStudents.get(i).getNumberofremainingcoursesforgraduation()!=null) {
				BestApplicantStrategyFactory myFactory = new BestApplicantStrategyFactory();
				BestApplicantStrategy myStrategy = myFactory.getStrategy(option);
				myStudent = myStrategy.findBestApplicant(possibleStudents, gradeLimit, courseLimit);

				if(myStudent == null) {
					flag = 1;
				} else {
					flag = 0;
					
					//update Assigned=true from SubjectDB
					Subject mySubject = subjectService.findById(subjectId);
					mySubject.setAssigned(true);
					subjectService.save(mySubject);
					
					//update Assigned=true from StudentDB
					myStudent.setAssigned(true);
					studentService.saveStudent(myStudent);
					
					//make ThesisDB
					Thesis myThesis = new Thesis(subjectId, myStudent.getId());
					thesisService.save(myThesis);
					
					//delete row from ApplicationDB
					applicationService.deleteByStudentid(myStudent.getId());
				}
			}
		}
		
		return "redirect:/professor/dashboard/applicationList";
		
	}
	
	@RequestMapping("/professor/dashboard/assignedDiplomaList")
	public String assignedDiplomaList(Model theModel) {
		List<Thesis> myThesis = thesisService.findAll();
		HashMap<Thesis, HashMap<Subject, Student>> myThesisList = new HashMap<Thesis, HashMap<Subject, Student>>();
		
		for(int i = 0; i<myThesis.size(); i++) {
			Subject mySubject = subjectService.findById(myThesis.get(i).getSubjectsid());
			Student myStudent = studentService.findById(myThesis.get(i).getStudentid());
			HashMap<Subject, Student> temp = new HashMap<Subject, Student>();
			temp.put(mySubject, myStudent);
			myThesisList.put(myThesis.get(i), temp);
		}
		
		theModel.addAttribute("thesisList", myThesisList);
		
		return "/professor/assignedDiplomaList";
		
	}
	
	@RequestMapping("/professor/dashboard/assignedDiplomaList/grade")
	public String setGrade(@RequestParam("thesisId") int thesisId, Model theModel) {
		System.out.println(thesisId);
		
		Thesis myThesis = thesisService.findById(thesisId);
		
		theModel.addAttribute("myThesis", myThesis);
		
		return "/professor/applyGrade";
	}
	
	@RequestMapping("/professor/dashboard/assignedDiplomaList/grade/save")
	public String saveGrade(@ModelAttribute("myThesis") Thesis theThesis, Model theModel) {
		
		theThesis.setGrade((float)(theThesis.getImplementationgrade()*0.7 + theThesis.getReportgrade()*0.15 + theThesis.getPresentationgrade()*0.15));
		
		thesisService.save(theThesis);
		
		return "redirect:/professor/dashboard/assignedDiplomaList";
	}
	
}
