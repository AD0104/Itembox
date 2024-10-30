package com.itembox.itembox.business.services;

import com.itembox.itembox.persistance.dto.AuthLoginDto;

public interface IAuthService {
    String login(AuthLoginDto loginDto);
}
