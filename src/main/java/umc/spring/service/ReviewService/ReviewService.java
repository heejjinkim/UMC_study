package umc.spring.service.ReviewService;

import umc.spring.domain.Review;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.StoreRequestDTO;

public interface ReviewService {
    public Review createReview(StoreRequestDTO.ReviewCreateDto request);
}
