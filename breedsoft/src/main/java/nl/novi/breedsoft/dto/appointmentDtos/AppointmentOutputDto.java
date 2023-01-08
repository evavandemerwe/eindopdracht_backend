package nl.novi.breedsoft.dto.appointmentDtos;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import lombok.Data;
import nl.novi.breedsoft.model.management.DomesticatedDog;
import java.time.LocalDate;
@Data
public class AppointmentOutputDto {
    private Long id;
    private LocalDate appointmentDate;
    private String subject;
    @JsonIncludeProperties({"id", "name", "sex", "dateOfBirth", "breed", "kindOfHair"})
    private DomesticatedDog domesticatedDog;
}
