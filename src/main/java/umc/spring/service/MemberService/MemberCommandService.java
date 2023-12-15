package umc.spring.service.MemberService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberRequestDTO;

import java.util.List;

public interface MemberCommandService {
    public Member joinMember(MemberRequestDTO.JoinDto request);

    boolean existMember(List<Long> value);

    Page<Review> getReviewList(Long memberId, Integer page);

    Page<MemberMission> getMemberMissionList(Long memberId, String missionStatus, Integer page);
}
