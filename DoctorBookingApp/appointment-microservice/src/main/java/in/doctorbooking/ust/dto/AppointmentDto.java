package in.doctorbooking.ust.dto;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public record AppointmentDto (int appointmentId,
                              String appointmentDate,
                              String appointmentTime,
                              int doctorId,
                              String doctorName,
                              String doctorSpeciality,
                              String doctorLocation,
                              int userId){
}
