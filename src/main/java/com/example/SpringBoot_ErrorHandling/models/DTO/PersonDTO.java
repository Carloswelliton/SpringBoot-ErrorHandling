package com.example.SpringBoot_ErrorHandling.models.DTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record PersonDTO(
  Long id,

  @NotBlank
  String name,

  @NotBlank
  String cpf,

  @Max(value=105)
  @Min(value=1)
  Integer age,

  @NotBlank
  String color,

  @NotBlank
  Double height
  
) {
  
}