package com.clg_management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.clg_management.entity.Contact;
import com.clg_management.entity.EventEntiy;
import com.clg_management.entity.ExamFormData;
import com.clg_management.entity.Feedback;
import com.clg_management.entity.Student;
import com.clg_management.entity.TimeTableClass;
import com.clg_management.repository.ContactRepo;
import com.clg_management.repository.EventRepo;
import com.clg_management.repository.ExamFormRepo;
import com.clg_management.repository.FeedbackRepo;
import com.clg_management.repository.TimeTabelRepo;
import com.clg_management.repository.UserRepo;

import jakarta.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private TimeTabelRepo tr;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public Student saveUser(Student student) {
		String password = passwordEncoder.encode(student.getPassword());
		student.setPassword(password);
		student.setRole("ROLE_STUDENT");
		Student newuser = userRepo.save(student);

		return newuser;
	}

	@Override
	public void removeSessionMessage() {

		HttpSession session = ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest()
				.getSession();

		session.removeAttribute("msg");
	}

	@Autowired
	private ContactRepo cr;

	@Override
	public Contact saveContactInfo(Contact contact) {
		Contact contactMessage = cr.save(contact);
		return contactMessage;
	}

	@Override
	public List<Student> getStudentData() {
		List<Student> ls = userRepo.getStudentData();
		return ls;
	}

	@Override
	public void deleteById(int id) {
		userRepo.deleteById(id);

	}

	@Override
	public Student editById(int id) {

		Optional<Student> ss = userRepo.findById(id);

		if (ss.isPresent()) {
			return ss.get();
		}

		return null;

	}

	@Override
	public Student updateById(Student student) {

		return userRepo.save(student);
	}

	@Override
	public List<Contact> getAllMessage() {
		List<Contact> lst = cr.findAll();
		return lst;
	}

	@Override
	public void deleteMessage(int id) {

		cr.deleteById(id);
	}

	@Override
	public TimeTableClass saveTT(TimeTableClass tt) {

		return tr.save(tt);

	}

	@Override
	public List<TimeTableClass> getTimeTable() {
		List<TimeTableClass> tt = tr.findAll();
		return tt;
	}

	@Autowired
	private ExamFormRepo er;

	@Override
	public ExamFormData saveForm(ExamFormData ee) {
		// TODO Auto-generated method stub
		return er.save(ee);
	}

	@Override
	public List<ExamFormData> examData() {
		List<ExamFormData> lst = er.findAll();
		return lst;
	}

	@Override
	public void deleteExamFrom(int id) {
		er.deleteById(id);

	}

	@Override
	public ExamFormData editExamFrom(int id) {
		Optional<ExamFormData> ss = er.findById(id);

		if (ss.isPresent()) {
			return ss.get();
		}

		return null;

	}

//Save Event 
	@Autowired
	private EventRepo eer;

	@Override
	public EventEntiy saveEventsData(EventEntiy E) {
		// TODO Auto-generated method stub
		return eer.save(E);
	}

	@Override
	public List<EventEntiy> eventData() {
		List<EventEntiy> lst = eer.findAll();
		return lst;
	}

	@Autowired
	private FeedbackRepo fr;

	@Override
	public Feedback saveFeedback(Feedback f) {
		// TODO Auto-generated method stub
		return fr.save(f);
	}

	@Override
	public List<Feedback> allFeedbacks() {
		List<Feedback> lst = fr.findAll();
		return lst;
	}

	@Override
	public List<Student> getStaffData() {
		// TODO Auto-generated method stub
		return userRepo.getStaffData();
	}

}
