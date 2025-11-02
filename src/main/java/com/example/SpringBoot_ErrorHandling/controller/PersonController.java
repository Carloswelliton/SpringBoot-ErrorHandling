package com.example.SpringBoot_ErrorHandling.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBoot_ErrorHandling.models.DTO.PersonDTO;
import com.example.SpringBoot_ErrorHandling.service.PersonService;


@RestController
@RequestMapping("/pessoas")
public class PersonController {

  @Autowired
  private PersonService service;

  @GetMapping
  public ResponseEntity<List<PersonDTO>> findAll(){
    return ResponseEntity.ok(service.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<PersonDTO> findById(@PathVariable Long id){
    return ResponseEntity.ok(service.findById(id));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id){
    service.delete(id);
    return ResponseEntity.noContent().build();
  }

  @PostMapping
  public ResponseEntity<PersonDTO> create(@RequestBody PersonDTO dto){
    PersonDTO saved = service.create(dto);
    return ResponseEntity.status(HttpStatus.CREATED).body(saved);
  }

  @PutMapping("/{id}")
  public ResponseEntity<PersonDTO> update(@PathVariable Long id, @RequestBody PersonDTO dto){
    PersonDTO updated = service.update(id, dto);
    return ResponseEntity.ok(updated);
  }
  
  
}
