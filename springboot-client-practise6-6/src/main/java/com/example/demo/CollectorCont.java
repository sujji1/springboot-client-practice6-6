package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.domain.Sort;
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
public class CollectorCont {

	@Autowired
	private CollectorRepo cr;
	@GetMapping("/PAGEONE")
	public List<Collector>getpageone(){
		Pageable paging = PageRequest.of(0, 5, Sort.by("pid").ascending());
		Page<Collector> p = cr.findAll(paging);
		return p.getContent();
	}
	@PostMapping("/collect")
	public ResponseEntity<Collector>save(@RequestBody Collector c){
		return new ResponseEntity<Collector>(cr.save(c),HttpStatus.CREATED);
	}
	@GetMapping("/collect")
	public ResponseEntity<List<Collector>>getall(){
		return new ResponseEntity<>(cr.findAll(),HttpStatus.CREATED);
	}
	@GetMapping("/collect/{id}")
	public ResponseEntity<Collector>getdata(@PathVariable int id,@RequestBody Collector c){
		Optional<Collector>op=cr.findById(id);
		if(op.isPresent()) {
			return new ResponseEntity<>(op.get(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	@PutMapping("/collect/{id}")
	public ResponseEntity<Collector>update(@PathVariable int id,@RequestBody Collector c){
		Optional<Collector>op=cr.findById(id);
		if(op.isPresent()) {
			return new ResponseEntity<>(cr.save(op.get()),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	@DeleteMapping("/collect/{id}")
	public ResponseEntity<Collector>delete(@PathVariable int id,@RequestBody Collector c){
		Optional<Collector>op=cr.findById(id);
		if(op.isPresent()) {
			cr.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
