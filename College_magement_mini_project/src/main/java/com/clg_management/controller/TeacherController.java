package com.clg_management.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.clg_management.entity.Student;
import com.clg_management.entity.TimeTableClass;
import com.clg_management.service.UserServiceImpl;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

	@Autowired
	private UserServiceImpl sc;

	@GetMapping("/profile")
	public String profile() {
		return "admin_profile";
	}

	@GetMapping("/staffDashboard")
	public String staffDashBoard() {
		return "StaffDashBoard";
	}

	@GetMapping("/stduentData")
	public String getAllStduets(Model m) {

		List<Student> lst = sc.getStudentData();
		m.addAttribute("lst", lst);
		return "/SeeAllStudentsToStaff";
	}

	// Show Time table
	@GetMapping("/showtimeTable")
	public String timeTableShow(Model m) {
		// Printing timeTable
		List<TimeTableClass> lst = sc.getTimeTable();
		m.addAttribute("lst", lst);
		return "TimeTableDisplay";

	}

}
