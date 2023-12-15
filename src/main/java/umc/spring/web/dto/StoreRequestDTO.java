package umc.spring.web.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class StoreRequestDTO {

    @Getter
    public static class StoreCreateDto {
        @NotBlank
        String name;
        @NotBlank
        String address;
        @NotNull
        Long regionId;
        @NotNull
        Long foodCategoryId;
    }

    @Getter
    public static class ReviewCreateDto{
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
