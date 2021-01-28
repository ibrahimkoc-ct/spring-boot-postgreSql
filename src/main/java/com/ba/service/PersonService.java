package com.ba.service;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;

import com.ba.dto.PersonDTO;

public interface PersonService {
	
	PersonDTO save(PersonDTO personDTO);
	
	void delete();
	
	List<PersonDTO> getAll();
	
	Page<PersonDTO> getAll(Pageable pageable);
}
