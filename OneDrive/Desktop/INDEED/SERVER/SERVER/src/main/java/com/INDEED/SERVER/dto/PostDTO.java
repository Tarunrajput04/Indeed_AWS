package com.INDEED.SERVER.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PostDTO {

    @NotEmpty(message = "Profile must not be empty")
    private String profile;

    @NotNull
    private String type;

    @NotNull
    private String description;

    @NotNull
    private String experience;

    @NotNull
    private String[] technology;

    @NotNull
    private String salary;
}
