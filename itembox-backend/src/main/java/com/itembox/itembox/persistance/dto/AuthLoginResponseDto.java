package com.itembox.itembox.persistance.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthLoginResponseDto {
    private String accessToken;
    private String tokenType = "Bearer ";
}
