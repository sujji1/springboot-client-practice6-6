package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PeopleCollle {

	@Autowired
	private PeopleRepo pr;
	@PostMapping("/people")
	public ResponseEntity< People>save(@RequestBody People p){
		return new ResponseEntity< People>(pr.save(p),HttpStatus.CREATED);
	}
	@GetMapping("/people")
	public ResponseEntity<List< People>>getall(){
		return new ResponseEntity<>(pr.findAll(),HttpStatus.CREATED);
	}
	@GetMapping("/people/{id}")
	public ResponseEntity< People>getdata(@PathVariable int pid,@RequestBody  People p){
		Optional< People>op=pr.findById(pid);
		if(op.isPresent()) {
			return new ResponseEntity<>(op.get(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	@PutMapping("/people/{id}")
	public ResponseEntity< People>update(@PathVariable int pid,@RequestBody  People p){
		Optional< People>op=pr.findById(pid);
		if(op.isPresent()) {
			return new ResponseEntity<>(pr.save(op.get()),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	@DeleteMapping("/people/{id}")
	public ResponseEntity< People>delete(@PathVariable int pid,@RequestBody  People p){
		Optional< People>op=pr.findById(pid);
		if(op.isPresent()) {
			pr.deleteById(pid);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
