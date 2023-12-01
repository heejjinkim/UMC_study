package umc.spring.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class MissionRequestDTO {

    @Getter
    public static class CreateDTO{
        @NotNull
        Long storeId;
        @NotBlank
        String title;
        @NotBlank
        String content;
        @NotNull
        Integer point;
        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate deadline;
    }
}
