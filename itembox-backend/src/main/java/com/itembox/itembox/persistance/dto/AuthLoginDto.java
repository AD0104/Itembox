package com.itembox.itembox.persistance.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthLoginDto {
    private String userNameOrEmail;
    private String password;
}
