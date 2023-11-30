package umc.spring.web.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ReviewRequestDTO {

    @Getter
    public static class JoinDto{
        @NotNull
        private Long memberId;
        @NotNull
        private Long storeId;
        @NotNull
        private float score;
        @NotBlank
        private String content;
    }
}
