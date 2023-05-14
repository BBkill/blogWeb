package com.example.readingbookservice.dto.req;

import com.example.readingbookservice.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RegisterReqDto {

    private String username;

    private String name;

    private int gender;

    private String phone;

    private String password;

    private String email;
}
