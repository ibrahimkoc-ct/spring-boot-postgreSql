package com.ba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ba.dto.PersonDTO;
import com.ba.service.impl.PersonServiceImpl;

@RestController
@RequestMapping("/person")
public class PersonController {
	@Autowired
	private PersonServiceImpl service;
	
	
	@PostMapping
	public ResponseEntity<PersonDTO> save(@RequestBody PersonDTO personDTO){
		PersonDTO personDb= service.save(personDTO);
		return ResponseEntity.ok(personDb);
		
	}
	
	@GetMapping
	public ResponseEntity<List<PersonDTO>> getallPerson(){
		return ResponseEntity.ok(service.getAll());
	}
}
