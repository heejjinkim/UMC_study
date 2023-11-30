package umc.spring.converter;

import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;

public class MissionConverter {

    public static MissionResponseDTO.createResultDTO toCreateResultDTO(Mission mission){
        return MissionResponseDTO.createResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(mission.getCreatedAt())
                .build();
    }

    public static Mission toMission(MissionRequestDTO.CreateDTO request, Store store){
        return Mission.builder()
                .point(request.getPoint())
                .title(request.getTitle())
                .content(request.getContent())
                .deadline(request.getDeadline())
                .store(store)
                .build();
    }
}
