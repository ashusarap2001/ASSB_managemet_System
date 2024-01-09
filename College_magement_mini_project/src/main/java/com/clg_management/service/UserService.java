package com.clg_management.service;

import java.util.List;

import com.clg_management.entity.Contact;
import com.clg_management.entity.EventEntiy;
import com.clg_management.entity.ExamFormData;
import com.clg_management.entity.Feedback;
import com.clg_management.entity.Student;
import com.clg_management.entity.TimeTableClass;

public interface UserService {

	public Student saveUser(Student student);

	public List<Student> getStudentData();

	public void removeSessionMessage();

	public Contact saveContactInfo(Contact contact);

	public void deleteById(int id);

	public Student editById(int id);

	public Student updateById(Student student);

	List<Contact> getAllMessage();
	

	public void deleteMessage(int id);

	public TimeTableClass saveTT(TimeTableClass tt);

	List<TimeTableClass> getTimeTable();

	public ExamFormData saveForm(ExamFormData ee);
	
	public List<ExamFormData> examData();
	
	public void deleteExamFrom(int id);

	public ExamFormData editExamFrom(int id);
	
	//Save Event Data 
	public EventEntiy saveEventsData(EventEntiy E);
	public List<EventEntiy> eventData();
	
	//feedback save
	
	public Feedback saveFeedback(Feedback f);
	
	public List<Feedback> allFeedbacks();
	
	public List<Student> getStaffData();

}
