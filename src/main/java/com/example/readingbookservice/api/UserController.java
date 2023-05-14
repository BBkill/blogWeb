package com.example.readingbookservice.api;

import com.example.readingbookservice.domain.User;
import com.example.readingbookservice.dto.req.LoginReqDto;
import com.example.readingbookservice.dto.req.RegisterReqDto;
import com.example.readingbookservice.dto.res.LoginResDto;
import com.example.readingbookservice.dto.res.RegisterResDto;
import com.example.readingbookservice.service.UserService;
import com.example.readingbookservice.util.JsonUtil;
import com.example.readingbookservice.util.Result;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/user")
@CrossOrigin
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<Result<LoginResDto>> login(@RequestBody LoginReqDto reqDto) {
        System.out.println("login___" + JsonUtil.toJSONString(reqDto));
        return ResponseEntity.ok(userService.login(reqDto));
    }

    @PostMapping("/register")
    public ResponseEntity<Result<? extends User>> register(@RequestBody RegisterReqDto reqDto) {
        return ResponseEntity.ok(userService.register(reqDto));
    }
}
