package in.doctorbooking.ust.controller;

import in.doctorbooking.ust.domain.Rating;
import in.doctorbooking.ust.dto.RatingDto;
import in.doctorbooking.ust.dto.RequestDto;
import in.doctorbooking.ust.service.AppointmentService;
import in.doctorbooking.ust.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/ratings")
public class RatingController {

    private RatingService ratingService;

    @Autowired
    AppointmentService appointmentService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GetMapping("")
    public ResponseEntity<List<RatingDto>> getAll(){
        List<Rating> list = ratingService.getAll();
        List<RatingDto> ratingList = list.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(ratingList);
    }

    @PostMapping("")
    public ResponseEntity<RatingDto> giveRating(@RequestBody RequestDto requestDto){
        var appointmentDto = appointmentService.getAppointment(requestDto.appointmentId());
        if(appointmentDto == null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        Rating rating = new Rating();
        rating.setAppointmentDate(appointmentDto.appointmentDate());
        rating.setAppointmentId(appointmentDto.appointmentId());
        rating.setRating(requestDto.rating());
        rating.setReview(requestDto.review());
        rating.setDoctorId(appointmentDto.doctorId());
        rating.setDoctorName(appointmentDto.doctorName());
        rating.setUserId(appointmentDto.userId());

        ratingService.saveRating(rating);

        return ResponseEntity.status(HttpStatus.OK).body(convertToDto(rating));

    }


    public RatingDto convertToDto(Rating rating){
        return new RatingDto(rating.getRatingId(),rating.getRating(),rating.getReview(),rating.getDoctorId()
                ,rating.getDoctorName(),rating.getAppointmentId(),rating.getAppointmentDate(),rating.getUserId());
    }

}
