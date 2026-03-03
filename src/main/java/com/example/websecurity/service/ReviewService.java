package com.example.websecurity.service;

import com.example.websecurity.exception.WebSecMissingDataException;
import com.example.websecurity.persistence.Review;
import com.example.websecurity.persistence.ReviewRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static lombok.AccessLevel.PACKAGE;

@Service
@AllArgsConstructor(access = PACKAGE)
@Slf4j
public class ReviewService {

    private final ReviewRepository reviewRepository;


    public Review getReviewById(Long id) {
        return reviewRepository.findById(id).orElseThrow(() -> new WebSecMissingDataException("Review with id " + id + " not found"));
    }
}
