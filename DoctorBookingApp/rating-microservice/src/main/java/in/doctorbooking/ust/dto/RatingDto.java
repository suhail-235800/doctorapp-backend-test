package in.doctorbooking.ust.dto;

import java.time.LocalDate;

public record RatingDto (
        int ratingId,
        int rating,
        int doctorId,
        String doctorName,
        int appointmentId,
        String appointmentDate,
        int userId){
}
