package umc.spring.web.dto;

import lombok.Getter;

public class MemberMissionRequestDTO {

    @Getter
    public static class CreateDTO{
        Long memberId;
        Long missionId;
    }
}
