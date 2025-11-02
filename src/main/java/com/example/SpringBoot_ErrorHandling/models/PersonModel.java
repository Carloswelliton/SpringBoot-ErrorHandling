package com.example.SpringBoot_ErrorHandling.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="pessoas")
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class PersonModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable=false, name="nome")
  private String name;

  @Column(nullable=false, name="cpf")
  private String cpf;

  @Column(nullable=false, name="idade")
  private Integer age;

  @Column(nullable=false, name="cor")
  private String color;

  @Column(nullable=false, name="altura")
  private Double heigth;  
}
