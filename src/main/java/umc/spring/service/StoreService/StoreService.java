package umc.spring.service.StoreService;

import umc.spring.domain.Member;
import umc.spring.domain.Store;
import umc.spring.web.dto.StoreRequestDTO;

public interface StoreService {

    public Store joinStore(StoreRequestDTO.JoinDto request);
}
