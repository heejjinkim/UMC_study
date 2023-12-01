package umc.spring.web.dto;

import lombok.Getter;

import javax.validation.constraints.NotNull;

public class MemberMissionRequestDTO {

    @Getter
    public static class CreateDTO{
        @NotNull
        Long memberId;
        @NotNull
        Long missionId;
    }
}
