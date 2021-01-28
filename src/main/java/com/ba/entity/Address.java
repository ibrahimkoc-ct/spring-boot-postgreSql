package com.ba.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "person_address")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(of= {"id"})
public class Address implements Serializable{
	
	@Id
	@SequenceGenerator(name = "seq_person_address",allocationSize = 1)
	@GeneratedValue(generator = "seq_person_address",strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(length = 500,name = "address")
	private String address;
	
	@Enumerated
	private AddressType addressType;
	
	@Column(name = "enabled")
	private Boolean enabled;
	
	@ManyToOne
	@JoinColumn(name = "person_address_id")
	private Person person;
	
	
	public enum AddressType{
		HomeAddress,
		WorkAddress,
		Other
	}
}
