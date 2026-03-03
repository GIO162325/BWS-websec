package com.example.websecurity.api;

import com.example.websecurity.api.dto.MovieResponse;
import com.example.websecurity.api.dto.ReviewResponse;
import com.example.websecurity.facade.ReviewFacade;
import com.example.websecurity.persistence.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
@RequiredArgsConstructor
@Slf4j
@SecurityRequirement(name = "Bearer Authentication")
public class ReviewController {

    private final ReviewFacade reviewFacade;

    @Operation(summary = "Get movie by id", description = "Get movie by id")
    @GetMapping("/user/{userId}/review/{reviewId}")
    public ResponseEntity<ReviewResponse> getReviewById(
            @PathVariable Long userId,
            @PathVariable Long reviewId,
            Authentication authentication
    ) {
        User user = (User) authentication.getPrincipal();
        if(user.getId() != userId) {
            return ResponseEntity.badRequest().build();
        }
        log.info("Review Controller: User {} requested a review with id {}", user.getEmail(), reviewId);
        ReviewResponse reviewResponse = reviewFacade.getResponseById(reviewId);
        return ResponseEntity.ok(reviewResponse);
    }
}
