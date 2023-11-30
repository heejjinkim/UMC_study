package umc.spring.service.ReviewService;

import umc.spring.domain.Review;
import umc.spring.web.dto.ReviewRequestDTO;

public interface ReviewService {
    public Review createReview(ReviewRequestDTO.JoinDto request);
}
