package com.ba.service.impl;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.ba.dto.PersonDTO;
import com.ba.entity.Address;
import com.ba.entity.Person;
import com.ba.repository.AddressRepository;
import com.ba.repository.PersonRepository;
import com.ba.service.PersonService;


@Service
public class PersonServiceImpl implements PersonService{
	
	@Autowired
	private PersonRepository repository;
	
	@Autowired
	private AddressRepository addressRepository;

	@Override
	@Transactional
	public PersonDTO save(PersonDTO personDTO) {
		Assert.notNull(personDTO.getName(),"Name is not empty");
		
		Person person= new Person();
		person.setId(personDTO.getId());
		person.setLastname(personDTO.getLastname());
		person.setName(personDTO.getName());
		Person personDb=repository.save(person);
		List<Address> addresses= new ArrayList<Address>();
		personDTO.getAddress().forEach(item ->{
			Address address = new Address();
			address.setAddress(item);
			address.setAddressType(Address.AddressType.Other);
			address.setEnabled(true);
			address.setPerson(personDb);
			addresses.add(address);
		});
		addressRepository.saveAll(addresses);
		personDTO.setId(personDb.getId());
		return personDTO;
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PersonDTO> getAll() {
		List<Person> personList= repository.findAll();
		List<PersonDTO> personDTOList= new ArrayList<PersonDTO>();
		personList.forEach(item->{
			PersonDTO personDTO= new PersonDTO();
			personDTO.setId(item.getId());
			personDTO.setLastname(item.getLastname());
			personDTO.setName(item.getName());
			personDTO.setAddress(item.getAddress().stream().map(Address::getAddress).collect(Collectors.toList()));
			personDTOList.add(personDTO);

		});
		return personDTOList;
	}

	@Override
	public Page<PersonDTO> getAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
