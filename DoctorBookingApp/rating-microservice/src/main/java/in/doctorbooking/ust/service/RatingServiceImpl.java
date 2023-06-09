package in.doctorbooking.ust.service;

import in.doctorbooking.ust.domain.Appointment;
import in.doctorbooking.ust.domain.Rating;
import in.doctorbooking.ust.exceptions.RatingNotFoundException;
import in.doctorbooking.ust.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingServiceImpl implements RatingService{

    @Autowired
    RatingRepository ratingRepository;

    @Override
    public List<Rating> getAll() {
        Optional<List<Rating>> test = Optional.of(ratingRepository.findAll());
        if(test.isEmpty()){
            throw new RatingNotFoundException();
        }
        return test.get();
    }

    @Override
    public Rating saveRating(Rating rating) {
        return ratingRepository.save(rating);
    }
}
