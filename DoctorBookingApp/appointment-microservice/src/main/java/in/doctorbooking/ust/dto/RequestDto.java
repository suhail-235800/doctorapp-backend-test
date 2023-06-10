package in.doctorbooking.ust.dto;


import java.time.LocalDate;
import java.time.LocalTime;

public record RequestDto(LocalDate appointmentDate, LocalTime appointmentTime, int doctorId) {
}
