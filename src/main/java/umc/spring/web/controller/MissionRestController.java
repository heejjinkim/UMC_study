package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MemberConverter;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.MissionService.MissionService;
import umc.spring.web.dto.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {

    private final MissionService missionService;

    @PostMapping("/")
    public ApiResponse<MissionResponseDTO.createResultDTO> join(@RequestBody @Valid MissionRequestDTO.CreateDTO request){
        Mission mission = missionService.createMission(request);
        return ApiResponse.onSuccess(MissionConverter.toCreateResultDTO(mission));
    }

    @PostMapping("/challenge")
    public ApiResponse<MemberMissionResponseDTO.CreateResultDTO> challengeMission(@RequestBody @Valid MemberMissionRequestDTO.CreateDTO request){
        MemberMission memberMission = missionService.challengeMission(request);
        return ApiResponse.onSuccess(MemberMissionConverter.toCreateResultDTO(memberMission));
    }
}
