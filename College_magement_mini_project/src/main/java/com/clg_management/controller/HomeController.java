package com.clg_management.controller;

import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.clg_management.entity.Contact;
import com.clg_management.entity.Student;
import com.clg_management.repository.UserRepo;
import com.clg_management.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepo userRepo;
	@ModelAttribute
	public void commonUser(Principal p, Model m) 
	{
		if (p != null) {
			String email = p.getName();
			Student student = userRepo.findByEmail(email);
			m.addAttribute("user", student);
		}

	}

	@GetMapping("/")
	public String index() {
		return "index";
	}

	//Student Registration Page Controller
	@GetMapping("/studRegister")
	public String studentRegistration() {
		return "StudentRegistration";
	}
	
	//Login page Controller
	@GetMapping("/signin")
	public String login() {
		return "login";
	}


	
	
	@GetMapping("/courses")
	public String course() {
		return "courses";
	}
	
	@GetMapping("/about")
	public String about() {
		return "about";
	}
	

	@PostMapping("/addStudent")
	public String saveUser(@ModelAttribute Student student, HttpSession session, Model m) {

		Student s = userService.saveUser(student);

		if (s != null) {
			session.setAttribute("msg", "Register successfully");

		} else {
			session.setAttribute("msg", "Something wrong server");
		}
		return "redirect:/studRegister";
	}
	
	@Autowired UserService sc;

	@GetMapping("/contact")
	public String contat1() {
		return "contact";
	}

	@PostMapping("/saveMessage")
	
	public String contact(@ModelAttribute Contact contact ,HttpSession session , Model m) {
		Contact c=sc.saveContactInfo(contact);
		if (c != null) {
			session.setAttribute("msg", "Message Send  successfully");

		} else {
			session.setAttribute("msg", "Something wrong server");
		}
		
		return "redirect:/contact";
	}
	
	@GetMapping("/teacherRegi")
	public String teacherRegistration() {
		return "TeacherRegistration";
	}
	@PostMapping("/addTeacher")
	public String saveTeacher(@ModelAttribute Student student, HttpSession session, Model m,HttpServletRequest req) {

		
		String teacher=req.getParameter("teacherId");
		
		
		String teacherId="Teacher@123";
		if(teacherId.equals(teacher)) {
			Student s = userService.saveUser(student);

			if (s != null) {
			session.setAttribute("msg", "Register successfully");

			} else {
			session.setAttribute("msg", "Something wrong server");
			}
		}
		else {
			session.setAttribute("msg", "Teacher Id is wrong");
		}
		
		return "redirect:/teacherRegi";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
