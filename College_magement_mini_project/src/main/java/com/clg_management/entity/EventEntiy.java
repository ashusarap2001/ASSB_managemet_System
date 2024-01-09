package com.clg_management.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "eventData")
public class EventEntiy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		private String e_name;
	private String discription;
	private String eventDate;
	private String eventTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getE_name() {
		return e_name;
	}
	public void setE_name(String e_name) {
		this.e_name = e_name;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public String getEventDate() {
		return eventDate;
	}
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}
	public String getEventTime() {
		return eventTime;
	}
	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}
	@Override
	public String toString() {
		return "EventEntiy [id=" + id + ", e_name=" + e_name + ", discription=" + discription + ", eventDate="
				+ eventDate + ", eventTime=" + eventTime + "]";
	}
	

}
