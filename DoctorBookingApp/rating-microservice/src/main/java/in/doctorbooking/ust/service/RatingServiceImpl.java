package in.doctorbooking.ust.service;

import in.doctorbooking.ust.domain.Rating;
import in.doctorbooking.ust.exceptions.RatingNotFoundException;
import in.doctorbooking.ust.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingServiceImpl implements RatingService{


    private RatingRepository ratingRepository;

    public RatingServiceImpl(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public List<Rating> getAll() {
        List<Rating> test = ratingRepository.findAll();
        if(test.isEmpty()||test==null){
            throw new RatingNotFoundException("No ratings found");
        }
        return test;
    }

    @Override
    public Rating saveRating(Rating rating) {
        return ratingRepository.save(rating);
    }

}
