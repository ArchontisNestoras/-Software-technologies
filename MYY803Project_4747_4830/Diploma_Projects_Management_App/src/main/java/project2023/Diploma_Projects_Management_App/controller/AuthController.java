package project2023.Diploma_Projects_Management_App.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import project2023.Diploma_Projects_Management_App.model.Professor;
import project2023.Diploma_Projects_Management_App.model.Role;
import project2023.Diploma_Projects_Management_App.model.Student;
import project2023.Diploma_Projects_Management_App.model.User;
import project2023.Diploma_Projects_Management_App.service.ProfessorService;
import project2023.Diploma_Projects_Management_App.service.StudentService;
import project2023.Diploma_Projects_Management_App.service.UserService;

@Controller
public class AuthController {
	@Autowired
    UserService userService;
	@Autowired
    StudentService studentService;
	@Autowired
    ProfessorService professorService;

    @RequestMapping("/login")
    public String login(){
        return "auth/signin";
    }

    @RequestMapping("/register")
    public String register(Model model){
        model.addAttribute("user", new User());
        return "auth/signup";
    }

    @RequestMapping("/save")
    public String registerUser(@ModelAttribute("user") User user, Model model){
       
        if(userService.isUserPresent(user)){
            model.addAttribute("successMessage", "User already registered!");
            return "auth/signin";
        }

        userService.saveUser(user);
        
        if(user.getRole() == Role.STUDENT) {
	    	Student student = new Student(user.getId(), false);
	    	studentService.saveStudent(student);
	    }
        else if(user.getRole() == Role.PROFESSOR) {
	    	Professor professor = new Professor(user.getId());
	    	professorService.saveProfessor(professor);
	    }
        
        model.addAttribute("successMessage", "User registered successfully!");

        return "auth/signin";
    }
}
