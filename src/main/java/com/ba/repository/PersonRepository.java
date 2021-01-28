package com.ba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ba.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
