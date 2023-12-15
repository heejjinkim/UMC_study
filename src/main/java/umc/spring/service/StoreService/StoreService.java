package umc.spring.service.StoreService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.web.dto.StoreRequestDTO;

import java.util.List;
import java.util.Optional;

public interface StoreService {

    public Store joinStore(StoreRequestDTO.StoreCreateDto request);

    Optional<Store> findStore(Long id);

    Page<Review> getReviewList(Long StoreId, Integer page);

    boolean existStore(List<Long> values);
}
