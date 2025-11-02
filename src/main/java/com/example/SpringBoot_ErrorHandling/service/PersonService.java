package com.example.SpringBoot_ErrorHandling.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBoot_ErrorHandling.models.PersonModel;
import com.example.SpringBoot_ErrorHandling.models.DTO.PersonDTO;
import com.example.SpringBoot_ErrorHandling.repository.PersonRepository;

@Service
public class PersonService {

  @Autowired
  private PersonRepository repository;


  //Para listar precisa de uma Lista passando o DTO como parâmetro, depois retornar o repository.findAll()
  //e então transformar essa lista em um fluxo (Stream) e usar o map para listar quais informações vão
  //aparecer quando essa função for chamada na API
  public List<PersonDTO> findAll(){
    return repository.findAll()
    .stream()
    .map(p -> new PersonDTO(
      p.getId(),
      p.getName(),
      p.getCpf(),
      p.getAge(),
      p.getColor(),
      p.getHeigth()
    ))
    .toList();
  }

    //Para encontrar uma entidade por id, devemos receber esse id nos parâmetros da função
  //instanciar a model que recebe a função findById do repository
  //e depois retornar um DTO com as informações necessárias
  public PersonDTO findById(Long id){
    PersonModel person = repository.findById(id).orElseThrow();
    return new PersonDTO(
      person.getId(),
      person.getName(),
      person.getCpf(),
      person.getAge(),
      person.getColor(),
      person.getHeigth()
    );
  }  

  //Para salvar é passar no parametro da função o DTO que vai ser recebido da chamada da função (PersonDTo dto)
  //Instanciar o model da classe para receber o RequestBody do dto, instanciar a model novamente para salvar
  //esse recebimento com o repository.save() e então retornar uma dto com os campos que quer mostrar na resposta
  //htto da api
  public PersonDTO create(PersonDTO dto){
    PersonModel person = new PersonModel();
    person.setName(dto.name());
    person.setCpf(dto.cpf());
    person.setAge(dto.age());
    person.setColor(dto.color());
    person.setHeigth(dto.height());

    PersonModel saved = repository.save(person);

    return new PersonDTO(
      saved.getId(),
      saved.getName(),
      saved.getCpf(),
      saved.getAge(),
      saved.getColor(),
      saved.getHeigth()
    );
  }

  //Para deletar uma entidade do banco de dados precisar receber no parametro da função um id
  //e retornar uma função delete do repository
  public void delete(Long id){
    repository.deleteById(id);;
  }

  //Para atualizar uma entidade no bd, precisamos passar no parametro da função um objeto que será modificado e o id
  //de quem será modificado
  //uma instancia da model devera receber a função findById do repository
  //fazer o set com as informações recebidas do objeto passado no RequestBody
  //e em seguida uma instancia do model com a entidade atualizada recebe um repoository.save() com a instancia
  //criada que recebeu o requestBody
  public PersonDTO update(Long id, PersonDTO dto){
    PersonModel person = repository.findById(id).orElseThrow();
    person.setName(dto.name());
    person.setCpf(dto.cpf());
    person.setAge(dto.age());
    person.setColor(dto.color());
    person.setHeigth(dto.height());
    PersonModel merged = repository.save(person);
    
    return new PersonDTO(merged.getId(),
    merged.getName(),
    merged.getCpf(),
    merged.getAge(),
    merged.getColor(),
    merged.getHeigth());
  }




}
