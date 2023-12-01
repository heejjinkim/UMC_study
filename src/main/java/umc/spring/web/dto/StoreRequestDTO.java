package umc.spring.web.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class StoreRequestDTO {

    @Getter
    public static class JoinDto{
        @NotBlank
        String name;
        @NotBlank
        String address;
        @NotNull
        Long regionId;
        @NotNull
        Long foodCategoryId;
    }
}
