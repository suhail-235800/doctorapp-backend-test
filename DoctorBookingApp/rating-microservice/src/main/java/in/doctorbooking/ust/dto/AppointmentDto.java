package in.doctorbooking.ust.dto;

public record AppointmentDto(int appointmentId,
                             String appointmentDate,
                             String appointmentTime,
                             int doctorId,
                             String doctorName,
                             String doctorSpeciality,
                             String doctorLocation,
                             int userId){
}
