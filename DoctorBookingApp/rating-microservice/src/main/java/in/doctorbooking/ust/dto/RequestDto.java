package in.doctorbooking.ust.dto;

public record RequestDto (
        int ratingId,
        int rating,
        String review,
        int appointmentId
){
}
