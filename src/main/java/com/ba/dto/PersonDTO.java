package com.ba.dto;

import java.util.List;


import lombok.Data;

@Data
public class PersonDTO {
	
	private Long id;
	

	private String name;
	

	private String lastname;
	

	private List<String> address;

}
