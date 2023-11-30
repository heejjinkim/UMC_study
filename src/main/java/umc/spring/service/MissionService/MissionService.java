package umc.spring.service.MissionService;

import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberMissionRequestDTO;

public interface MissionService {
    public MemberMission challengeMission(MemberMissionRequestDTO.CreateDTO request);
}
