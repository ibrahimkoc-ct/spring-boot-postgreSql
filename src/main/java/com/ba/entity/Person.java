package com.ba.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "person")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(of= {"id"})
public class Person implements Serializable {
	
	@Id
	@SequenceGenerator(name = "seq_person",allocationSize = 1)
	@GeneratedValue(generator = "seq_person",strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(length = 100, name = "name")
	private String name;
	
	@Column(length = 100, name = "lastname")
	private String lastname;
	
	@OneToMany
	@JoinColumn(name = "person_address_id")
	private List<Address> address;

}
