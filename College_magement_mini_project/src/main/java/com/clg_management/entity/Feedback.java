package com.clg_management.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "feedback")
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private String phone;
	private String Experience;
	private String Elements;
	private String venue_Logistics;
	private String speakers;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getExperience() {
		return Experience;
	}
	public void setExperience(String experience) {
		Experience = experience;
	}
	public String getElements() {
		return Elements;
	}
	public void setElements(String elements) {
		Elements = elements;
	}
	public String getVenue_Logistics() {
		return venue_Logistics;
	}
	public void setVenue_Logistics(String venue_Logistics) {
		this.venue_Logistics = venue_Logistics;
	}
	public String getSpeakers() {
		return speakers;
	}
	public void setSpeakers(String speakers) {
		this.speakers = speakers;
	}
	@Override
	public String toString() {
		return "Feedback [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", Experience="
				+ Experience + ", Elements=" + Elements + ", venue_Logistics=" + venue_Logistics + ", speakers="
				+ speakers + "]";
	}
	
	
	

}
