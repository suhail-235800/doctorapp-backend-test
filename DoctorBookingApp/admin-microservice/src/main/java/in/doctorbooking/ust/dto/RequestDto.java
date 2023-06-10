package in.doctorbooking.ust.dto;

public record RequestDto(
        int doctorId,
        String doctorName,
        String doctorSpecialization,
        String doctorLocation,
        int doctorRating) {
}
