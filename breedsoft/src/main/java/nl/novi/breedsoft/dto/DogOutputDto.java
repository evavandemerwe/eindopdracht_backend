package nl.novi.breedsoft.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import lombok.Data;
import nl.novi.breedsoft.model.animal.Person;
import nl.novi.breedsoft.model.animal.enumerations.Breed;
import nl.novi.breedsoft.model.animal.enumerations.BreedGroup;
import nl.novi.breedsoft.model.animal.enumerations.Sex;

import java.time.LocalDate;
import java.util.ArrayList;

@Data
public class DogOutputDto {
    private long id;
    private String name;
    private String hairColor;
    private String food;
    private Sex sex;
    private double weightInGrams;
    private String kindOfHair;
    private int dogYears;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private String chipNumber;
    private Breed breed;
    private BreedGroup breedGroup;
    private ArrayList<String> Litter;

    @JsonIncludeProperties({"id", "firstName", "lastName", "street", "houseNumber", "houseNumberExtension", "zipCode", "city", "country"})
    private Person person;
}
