package in.doctorbooking.ust.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import java.io.StringReader;
import java.time.LocalDate;

public record RatingDto (
        int ratingId,
        int rating,
        String review,
        int doctorId,
        String doctorName,
        int appointmentId,
        @JsonFormat(pattern = "yyyy-MM-dd")
        @JsonDeserialize(using = LocalDateDeserializer.class)
        LocalDate appointmentDate,
        int userId){
}
