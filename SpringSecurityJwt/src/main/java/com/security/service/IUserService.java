package com.security.service;

import java.util.List;

import com.security.entity.UserInfo;
import com.security.payload.TokenRequest;
import com.security.payload.TokenResponse;

public interface IUserService {

	Integer registorUser(UserInfo userInfo);
    TokenResponse loginUser(TokenRequest request);
    List<UserInfo> getAllUser();
}
