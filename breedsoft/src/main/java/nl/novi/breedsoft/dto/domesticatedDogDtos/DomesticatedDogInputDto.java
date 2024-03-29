package nl.novi.breedsoft.dto.domesticatedDogDtos;

import jakarta.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import lombok.Data;
import nl.novi.breedsoft.model.management.VeterinarianAppointment;
import nl.novi.breedsoft.model.management.DomesticatedDog;
import nl.novi.breedsoft.model.management.MedicalData;
import nl.novi.breedsoft.model.management.Person;
import nl.novi.breedsoft.model.management.enumerations.Breed;
import nl.novi.breedsoft.model.management.enumerations.BreedGroup;
import nl.novi.breedsoft.model.animal.enumerations.Sex;
import nl.novi.breedsoft.model.management.enumerations.Status;
import nl.novi.breedsoft.utility.ValueOfEnum;
import java.time.LocalDate;
import java.util.List;

@Data
public class DomesticatedDogInputDto {
    @Null
    public Long id;

    @NotEmpty(message = "Please enter the name of the dog.")
    private String name;

    @NotEmpty(message = "Please enter the hair color of the dog.")
    private String hairColor;

    @NotEmpty(message = "Please enter dog's food.")
    private String food;

    @NotEmpty(message = "Please enter a sex.")
    @ValueOfEnum(enumClass = Sex.class, message = "Invalid sex.")
    private String sex;

    @NotNull(message = "Please enter a weight.")
    private double weightInGrams;

    @NotEmpty(message = "Please enter kind of hair.")
    private String kindOfHair;

    @NotNull
    private LocalDate dateOfBirth;

    //Can be empty
    private LocalDate dateOfDeath;

    @NotEmpty(message = "Please enter a chip number.")
    @Pattern(regexp = "[0-9]{15}")
    private String chipNumber;

    @NotEmpty(message = "Please enter a breed.")
    @ValueOfEnum(enumClass = Breed.class, message = "Invalid breed.")
    private String breed;

    @NotEmpty(message = "Please enter a breed group.")
    @ValueOfEnum(enumClass = BreedGroup.class, message = "Invalid breed group.")
    private String breedGroup;

    private int dogYears;

    private boolean canSee;

    private boolean canHear;

    private Long parentId;

    @NotEmpty(message = "Please enter a status for this dog.")
    @ValueOfEnum(enumClass = Status.class, message = "Invalid status.")
    private String dogStatus;

    @JsonIncludeProperties({"id", "firstName", "lastName", "street", "houseNumber", "houseNumberExtension", "zipCode", "city", "country"})
    private Person person;

    //Can be empty
    private List<DomesticatedDog> litters;

    private List<VeterinarianAppointment> veterinarianAppointments;

    private List<MedicalData> medicalData;
}
