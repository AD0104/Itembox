package com.itembox.itembox.persistance.dto.http;

import com.itembox.itembox.persistance.dto.AuthLoginResponseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AuthGenericResponse {
   private String message;
    private Integer code;
    private AuthLoginResponseDto data;
}
