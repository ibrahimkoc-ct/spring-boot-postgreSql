package com.ba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ba.entity.Address;

public interface AddressRepository  extends JpaRepository<Address, Long>{

}
