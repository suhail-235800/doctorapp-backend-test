package in.doctorbooking.ust.repository;

import in.doctorbooking.ust.domain.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
}
