package in.doctorbooking.ust.repository;

import in.doctorbooking.ust.domain.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;

public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {

    Appointment findByAppointmentDateAndAppointmentTime(LocalDate date, LocalTime time);
    Appointment findByDoctorId(int doctorId);
}
