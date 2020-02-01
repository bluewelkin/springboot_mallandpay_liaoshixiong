package com.tx.mall.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserForm {

    @NotBlank //用于String
//    @NotEmpty 用于集tring合
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String email;
}
