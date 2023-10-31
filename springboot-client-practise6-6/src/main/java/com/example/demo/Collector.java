package com.example.demo;

import jakarta.persistence.*;

@Entity
public class Collector {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String profesion;
	@ManyToOne(cascade=CascadeType.ALL)
	private People people;
	public Collector() {
		
	}
	public Collector(int id, String name, String profesion, People people) {
		super();
		this.id = id;
		this.name = name;
		this.profesion = profesion;
		this.people = people;
	}
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
	public String getProfesion() {
		return profesion;
	}
	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}
	public People getPeople() {
		return people;
	}
	public void setPeople(People people) {
		this.people = people;
	}
	@Override
	public String toString() {
		return "Collector [id=" + id + ", name=" + name + ", profesion=" + profesion + ", people=" + people + "]";
	}
	
}
