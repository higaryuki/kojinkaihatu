package com.example.springwebtask.Entity.form;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UserForm {

    @NotEmpty(message = "IDは必須です")
    private String loginId;
    @NotEmpty(message = "PASSは必須です")
    private String password;
}
