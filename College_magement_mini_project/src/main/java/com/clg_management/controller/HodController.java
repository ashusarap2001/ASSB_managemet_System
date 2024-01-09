package com.clg_management.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.clg_management.entity.Contact;
import com.clg_management.entity.EventEntiy;
import com.clg_management.entity.ExamFormData;
import com.clg_management.entity.Feedback;
import com.clg_management.entity.Student;
import com.clg_management.entity.TimeTableClass;
import com.clg_management.service.UserService;

@Controller
@RequestMapping("/hod")
public class HodController {
	@Autowired
	private UserService sc;

	@GetMapping("/hodDashbord")
	public String DHODashbord() {
		return "DHODashbord";
	}
//Display all students 
	@GetMapping("/allStudents")
	public String allDataStudents(Model m) {

		List<Student> lst = sc.getStudentData();
		m.addAttribute("lst", lst);
		
		List<Student>lst2=sc.getStaffData();
		System.out.print(lst2);

		return "/allStudentsData";
	}
	//Display all staff 
		@GetMapping("/allStaff")
		public String allStaff(Model m) {
			List<Student>lst=sc.getStaffData();
			m.addAttribute("lst", lst);
			return "/allStudentsData";
		}
	
//Delete Student  
	@GetMapping("/delete/{id}")
	public String DeleteStudent(@PathVariable int id) {
		sc.deleteById(id);
		return "redirect:/hod/allStudents";
	}

	//Edit student by id ;
	@GetMapping("/edit/{id}")
	public String editByIdStudent(@PathVariable int id, Model m) {
		Student ss = sc.editById(id);
		m.addAttribute("ss", ss);
		return "StudentEditPage";
	}
	//Save edit data 
	@PostMapping("/udataAddStudent")
	public String updateByIdStudent(Student student) {
		Student ss = sc.updateById(student);
		return "redirect:/hod/allStudents";
	}

	//Display all messages of contact us 
	@GetMapping("/allMessage")
	public String allMessage(Model m) {

		List<Contact> lst = sc.getAllMessage();
		m.addAttribute("lst", lst);
		return "allMessageData";
	}
//Delete the message from database
	@GetMapping("/deleteMessages/{id}")
	public String DeleteMessage(@PathVariable int id) {
		sc.deleteMessage(id);
		return "redirect:/hod/allMessageData";
	}

	//Display exam time table page 
	@GetMapping("/timeTable")
	public String timeTable() {
		return "TT";
	}

	//Add exam time table to data base 
	@PostMapping("/addTimeTable")
	public String saveTimeTable(@ModelAttribute TimeTableClass tt, Model m) {
		TimeTableClass t = sc.saveTT(tt);

		return "redirect:/hod/timeTable";

	}
//Display timetable from database
	@GetMapping("/showtimeTable")
	public String timeTableShow(Model m) {
		// Printing timeTable
		List<TimeTableClass> lst = sc.getTimeTable();
		m.addAttribute("lst", lst);
		return "TT";

	}

	@GetMapping("/examFromPage")
	public String examdata(Model m) {
		List<ExamFormData> lst = sc.examData();
		m.addAttribute("lst", lst);
		return "ExamFormData";
	}

	@GetMapping("/deleteExamForm/{id}")
	public String deleteExamForm(@PathVariable int id) {
		sc.deleteExamFrom(id);
		return "redirect:/hod/examFromPage";
	}
	
	@GetMapping("/eventPage")
	public String addEvetsPages() {
		return "AddEvents";
	}

	// Save Event
	@PostMapping("/saveEvent")
	public String saveEventDara(@ModelAttribute EventEntiy EE ,Model m) {
       EventEntiy s= sc.saveEventsData(EE);
		return "redirect:/hod/eventPage";
	}
	
	@GetMapping("/eventData")
	public String eventdata(Model m) {
		List<EventEntiy> lst = sc.eventData();
		m.addAttribute("lst", lst);
		return "redirect:/hod/eventPage";
	}
	
	@GetMapping("/allFeedbacks")
	public String feedbackData(Model M) {
		List<Feedback>lst =sc.allFeedbacks();
		M.addAttribute("lst", lst);
		return "AllfeedbackData";
	}
	//-----------------------------------------------------------------------
}