package com.example.readingbookservice.service.iml;

import com.example.readingbookservice.domain.User;
import com.example.readingbookservice.dto.req.LoginReqDto;
import com.example.readingbookservice.dto.req.RegisterReqDto;
import com.example.readingbookservice.dto.res.LoginResDto;
import com.example.readingbookservice.dto.res.RegisterResDto;
import com.example.readingbookservice.repo.UserRepo;
import com.example.readingbookservice.service.UserService;
import com.example.readingbookservice.util.Result;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

import static com.example.readingbookservice.util.Message.*;

@Service
@AllArgsConstructor
public class UserServiceIml implements UserService {

    private final UserRepo userRepo;
    private final ModelMapper mapper;

    public Result<LoginResDto> login(LoginReqDto dto) {
        String key = dto.getUsername();
        String pass = dto.getPassword();
        if (StringUtils.hasLength(key) && StringUtils.hasLength(pass)) {
            key = key.trim();
            pass = pass.trim();
            Optional<User> user = userRepo.findByEmailOrUsername(key, key);
            if (user.isPresent()) {
                System.out.println("user present_____");
                if (pass.equals(user.get().getPassword().trim())) {
                    LoginResDto loginResDto = mapper.map(user.get(), LoginResDto.class);
                    loginResDto.setPassword(null);
                    return Result.success(loginResDto);
                }
            }

        }
        return Result.fail(USERNAME_PASSWORD_WRONG);
    }

    public Result<? extends User> register(RegisterReqDto dto) {
        String valid = validateReg(dto);
        if (StringUtils.hasLength(valid)) {
            return Result.fail(valid);
        }
        User user = userRepo.save(mapper.map(dto, User.class));
        user.setPassword(null);
        return Result.success(user);
    }

    private String validateReg(RegisterReqDto dto) {
        String res = "";
        String username = dto.getUsername();
        String password = dto.getPassword();
        String name = dto.getName();
        String email = dto.getEmail();
        String phone = dto.getPhone();

        if (!StringUtils.hasLength(username)) {
            res = res.concat(INVALID_USERNAME).concat("\n");
        } else {
            username = username.trim();
            if (userRepo.existsUserByUsername(username)) {
                res = res.concat(USERNAME_EXISTED).concat("\n");
            }
        }

        if (!StringUtils.hasLength(password)) {
            res = res.concat(INVALID_PASSWORD).concat("\n");
        } else {
            password = password.trim();
        }

        if (!StringUtils.hasLength(name)) {
            res = res.concat(INVALID_NAME).concat("\n");
        } else {
            name = name.trim();
        }

        if (!StringUtils.hasLength(email)) {
            res = res.concat(INVALID_EMAIL).concat("\n");
        } else {
            email = email.trim();
            if (userRepo.existsUserByEmail(email)) {
                res = res.concat(EMAIL_EXISTED).concat("\n");
            }
        }
        if (StringUtils.hasLength(phone)) {
            phone = phone.trim();
        }
        return res;
    }
}
