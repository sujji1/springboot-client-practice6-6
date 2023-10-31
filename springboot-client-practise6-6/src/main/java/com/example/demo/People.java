package com.example.demo;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;

@Entity
public class People {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pid;
	private String place;
	public People() {
		
	}
	public People(int pid, String place) {
		super();
		this.pid = pid;
		this.place = place;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	@Override
	public String toString() {
		return "People [pid=" + pid + ", place=" + place + "]";
	}
	
}
