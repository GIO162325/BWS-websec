package com.example.websecurity.facade;


import com.example.websecurity.api.dto.ReviewResponse;
import com.example.websecurity.persistence.Review;
import com.example.websecurity.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReviewFacade {

    private final ReviewService reviewService;

    public ReviewResponse getResponseById(Long id) {
        Review review = reviewService.getReviewById(id);
        return ReviewResponse.builder()
                .id(review.getId())
                .movieTitle(review.getMovieTitle())
                .reviewText(review.getReviewText())
                .rating(review.getRating())
                .reviewDate(review.getCreated())
                .build();
    }
}
