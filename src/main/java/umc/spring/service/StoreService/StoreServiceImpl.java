package umc.spring.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.FoodCategoryHandler;
import umc.spring.apiPayload.exception.handler.RegionHandler;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.*;
import umc.spring.repository.*;
import umc.spring.web.dto.StoreRequestDTO;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;
    private final FoodCategoryRepository foodCategoryRepository;
    private final ReviewRepository reviewRepository;
    private final MissionRepository missionRepository;

    @Override
    @Transactional
    public Store joinStore(StoreRequestDTO.StoreCreateDto request) {
        Region region = regionRepository.findById(request.getRegionId())
                .orElseThrow(() -> new RegionHandler(ErrorStatus.REGION_NOT_FOUND));

        FoodCategory foodCategory = foodCategoryRepository.findById(request.getFoodCategoryId())
                .orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));

        Store newStore = StoreConverter.toStore(request, region, foodCategory);

        return storeRepository.save(newStore);
    }

    @Override
    public Optional<Store> findStore(Long id) {
        return storeRepository.findById(id);
    }

    @Override
    public Page<Review> getReviewList(Long StoreId, Integer page) {
        Store store = storeRepository.findById(StoreId).get();

        Page<Review> StorePage = reviewRepository.findAllByStore(store, PageRequest.of(page, 10));
        return StorePage;
    }

    @Override
    public boolean existStore(List<Long> values) {
        return values.stream()
                .allMatch(value -> storeRepository.existsById(value));
    }

    @Override
    public Page<Mission> getMissionList(Long storeId, int page) {
        Store store = storeRepository.findById(storeId).get();

        Page<Mission> storePage = missionRepository.findAllByStore(store, PageRequest.of(page, 10));
        return storePage;
    }
}
