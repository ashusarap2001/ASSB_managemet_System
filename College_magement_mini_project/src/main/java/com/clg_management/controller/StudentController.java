package com.clg_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clg_management.entity.EventEntiy;
import com.clg_management.entity.ExamFormData;
import com.clg_management.entity.Feedback;
import com.clg_management.entity.TimeTableClass;
import com.clg_management.repository.UserRepo;
import com.clg_management.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private UserService sc;
	
	@GetMapping("/studentDashboard")
	public String dashboars() {
		return "StudentDashboard";
	}
	@GetMapping("/profile")
	public String profile() {
		return "profile";
	}

	@GetMapping("/showtimeTable")
	public String timeTableShow(Model m)
	{
		//Printing timeTable
				List<TimeTableClass>lst = sc.getTimeTable();
				m.addAttribute("lst", lst);
		return "TimeTableDisplay";
		
	}
	@GetMapping("/examForm")
	public String examFromPage() {
		return "Examform";
	}
	
	@GetMapping("/instructionData")
	public String Instruction() {
		return "instruction";
	}
	//Save Exam form 
	@PostMapping("/examRegistration/Data")
	public String saveExam(@ModelAttribute ExamFormData ee,HttpSession session,Model m) {
		ExamFormData e = sc.saveForm(ee);
		if (e != null) {
			session.setAttribute("msg", "Submitted");

		} else {
			session.setAttribute("msg", "Something wrong server");
		}
		return "redirect:/student/examForm";
	}
	
	
	@GetMapping("/eventData")
	public String eventdata(Model m) {
		List<EventEntiy> lst = sc.eventData();
		m.addAttribute("lst", lst);
		return "/eventData";
	}
	@GetMapping("/feedback")
	public String feedbackPage() {
		return "FeedbackForm";
	}
	
	@PostMapping("/saveFeedback")
	public String saveFeedback(@ModelAttribute Feedback f) {
		Feedback ff = sc.saveFeedback(f);
		return "redirect:/student/feedback";
	}
	
}
