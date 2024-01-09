package com.clg_management.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "time_table")
public class TimeTableClass {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
private String subcode;
private String s_name;
private String type;
private String examDate;
private String examTime;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getSubcode() {
	return subcode;
}
public void setSubcode(String subcode) {
	this.subcode = subcode;
}
public String getS_name() {
	return s_name;
}
public void setS_name(String s_name) {
	this.s_name = s_name;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getExamDate() {
	return examDate;
}
public void setExamDate(String examDate) {
	this.examDate = examDate;
}
public String getExamTime() {
	return examTime;
}
public void setExamTime(String examTime) {
	this.examTime = examTime;
}
@Override
public String toString() {
	return "TimeTableClass [id=" + id + ", subcode=" + subcode + ", s_name=" + s_name + ", type=" + type + ", examDate="
			+ examDate + ", examTime=" + examTime + "]";
}


}
