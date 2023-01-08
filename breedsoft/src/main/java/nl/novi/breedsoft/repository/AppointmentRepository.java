package nl.novi.breedsoft.repository;

import nl.novi.breedsoft.model.management.VeterinarianAppointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<VeterinarianAppointment, Long> {
}
