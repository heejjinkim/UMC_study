package umc.spring.service.MissionService;

import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberMissionRequestDTO;
import umc.spring.web.dto.MissionRequestDTO;

public interface MissionService {
    public MemberMission challengeMission(MemberMissionRequestDTO.CreateDTO request);

    public Mission createMission(MissionRequestDTO.CreateDTO request);
}
