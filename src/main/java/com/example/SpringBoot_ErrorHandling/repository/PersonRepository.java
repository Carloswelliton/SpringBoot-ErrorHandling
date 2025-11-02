package com.example.SpringBoot_ErrorHandling.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringBoot_ErrorHandling.models.PersonModel;

public interface PersonRepository extends JpaRepository<PersonModel, Long>{
  
}
