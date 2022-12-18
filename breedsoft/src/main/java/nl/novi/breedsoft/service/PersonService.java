package nl.novi.breedsoft.service;
import nl.novi.breedsoft.dto.PersonInputDto;
import nl.novi.breedsoft.dto.PersonOutputDto;
import nl.novi.breedsoft.exception.RecordNotFoundException;
import nl.novi.breedsoft.model.animal.Person;
import nl.novi.breedsoft.model.animal.enumerations.Sex;
import nl.novi.breedsoft.repository.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    //Output Dto is used for representing data from database to the user
    //Get all persons
    public List<PersonOutputDto> getAllPersons() {
        List<Person> personList = personRepository.findAll();
        return transferPersonListToDtoList(personList);
    }

    //Get one person by ID
    public PersonOutputDto getPersonById(Long id) {
        if (personRepository.findById(id).isPresent()){
            Person person = personRepository.findById(id).get();
            return transferToOutputDto(person);
        } else {
            throw new RecordNotFoundException("Person not found in database");
        }
    }

    //Get person list by Name
    public List<PersonOutputDto> getPersonByName(String lastName) {
        if (personRepository.findByLastNameContaining(lastName) != null){
            List<Person> personList = personRepository.findByLastNameContaining(lastName);
            List<PersonOutputDto> personOutputDtoList = new ArrayList<>();
            for(Person person: personList) {
                personOutputDtoList.add(transferToOutputDto(person));
            }
            return personOutputDtoList;
        } else {
            throw new RecordNotFoundException("No person with this name found in database");
        }
    }

    //Create creates a new entity in the database
    public Long createPerson(PersonInputDto personInputDto){

        Person person = transferToPerson(personInputDto);
        personRepository.save(person);

        return person.getId();
    }

    //DELETE deletes an entity from the database if found
    public void deletePerson(@RequestBody Long id) {

        if (personRepository.findById(id).isPresent()){
            personRepository.deleteById(id);
        } else {
            throw new  RecordNotFoundException("No person with given ID found.");
        }
    }

    //PUT sends an enclosed entity of a resource to the server.
    //If the entity already exists, the server updates its data. Otherwise, the server creates a new entity
    public Object updatePerson(Long id, PersonInputDto personInputDto) {

        if (personRepository.findById(id).isPresent()){
            Person person = personRepository.findById(id).get();

            Person updatedPerson = transferToPerson(personInputDto);

            //Keeping the former id, as we will update the existing dog
            updatedPerson.setId(person.getId());

            personRepository.save(updatedPerson);

            return transferToOutputDto(updatedPerson);

        } else {
            createPerson(personInputDto);
            return personInputDto;
        }

    }
    //PATCH will only update an existing object,
    //with the properties mapped in the request body (that are not null).
    public PersonOutputDto patchPerson(long id, PersonInputDto personInputDto) {
        Optional<Person> personFound = personRepository.findById(id);

        if (personFound.isPresent()) {

            Person updatedPerson = personRepository.getReferenceById(id);
            if (personInputDto.getFirstName() != null) {
                updatedPerson.setFirstName(personInputDto.getFirstName());
            }
            if (personInputDto.getLastName() != null) {
                updatedPerson.setLastName(personInputDto.getLastName());
            }
            if (personInputDto.getSex() != null) {
                updatedPerson.setSex(Sex.valueOf(personInputDto.getSex()));
            }
            if (personInputDto.getDateOfBirth() != null) {
                updatedPerson.setDateOfBirth(personInputDto.getDateOfBirth());
            }
            if (personInputDto.getStreet() != null) {
                updatedPerson.setStreet(personInputDto.getStreet());
            }
            if (personInputDto.getHouseNumber() > 0) {
                updatedPerson.setHouseNumber(personInputDto.getHouseNumber());
            }
            if (personInputDto.getHouseNumberExtension() != null) {
                updatedPerson.setHouseNumberExtension(personInputDto.getHouseNumberExtension());
            }
            if (personInputDto.getZipCode() != null) {
                updatedPerson.setZipCode(personInputDto.getZipCode());
            }
            if (personInputDto.getCity() != null) {
                updatedPerson.setCity(personInputDto.getCity());
            }
            if (personInputDto.getCountry() != null) {
                updatedPerson.setCountry(personInputDto.getCountry());
            }

            personRepository.save(updatedPerson);

            return transferToOutputDto(updatedPerson);

        } else {

            throw new RecordNotFoundException("Person is not found.");

        }
    }

    //DTO helper classes
    public List<PersonOutputDto> transferPersonListToDtoList(List<Person> persons){
        List<PersonOutputDto> personDtoList = new ArrayList<>();

        for(Person person : persons) {
            PersonOutputDto dto = transferToOutputDto(person);
            personDtoList.add(dto);
        }
        return personDtoList;
    }

    public PersonOutputDto transferToOutputDto(Person person){

        PersonOutputDto personOutputDto = new PersonOutputDto();

        personOutputDto.setId(person.getId());
        personOutputDto.setFirstName(person.getFirstName());
        personOutputDto.setLastName(person.getLastName());
        personOutputDto.setAge(person.getAge());
        personOutputDto.setSex(person.getSex());
        personOutputDto.setStreet(person.getStreet());
        personOutputDto.setHouseNumber(person.getHouseNumber());
        personOutputDto.setHouseNumberExtension(person.getHouseNumberExtension());
        personOutputDto.setZipCode(person.getZipCode());
        personOutputDto.setCity(person.getCity());
        personOutputDto.setCountry(person.getCountry());

        return personOutputDto;
    }

    public Person transferToPerson(PersonInputDto dto){
        Person person = new Person();

        person.setFirstName(dto.getFirstName());
        person.setLastName(dto.getLastName());
        person.setSex(Sex.valueOf(dto.getSex()));
        person.setDateOfBirth(dto.getDateOfBirth());
        person.setStreet(dto.getStreet());
        person.setHouseNumber(dto.getHouseNumber());
        person.setHouseNumberExtension(dto.getHouseNumberExtension());
        person.setZipCode(dto.getZipCode());
        person.setCity(dto.getCity());
        person.setCountry(dto.getCountry());

        return person;
    }
}