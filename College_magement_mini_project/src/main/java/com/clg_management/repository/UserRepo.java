package com.clg_management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.clg_management.entity.Student;
@Repository

public interface UserRepo extends JpaRepository<Student, Integer> {

	public Student findByEmail(String emaill);
	
	  @Query(value="SELECT * FROM mini_project.student WHERE role = 'ROLE_STUDENT'",nativeQuery = true)
	   public List<Student> getStudentData();
 
	  @Query(value="SELECT * FROM mini_project.student WHERE role = 'ROLE_TEACHER'",nativeQuery = true)
	   public List<Student> getStaffData();
	  
	 

}
