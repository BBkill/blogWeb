package com.example.readingbookservice.service;

import com.example.readingbookservice.domain.User;
import com.example.readingbookservice.dto.req.LoginReqDto;
import com.example.readingbookservice.dto.req.RegisterReqDto;
import com.example.readingbookservice.dto.res.LoginResDto;
import com.example.readingbookservice.util.Result;

public interface UserService {

    Result<LoginResDto> login(LoginReqDto dto);

    Result<? extends User> register(RegisterReqDto dto);
}
