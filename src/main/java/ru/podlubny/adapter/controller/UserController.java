package ru.podlubny.adapter.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.podlubny.adapter.dto.UserInfoDto;
import ru.podlubny.adapter.service.UserService;

@RestController
@RequestMapping("api/v1/users")
@Slf4j
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping()
    public UserInfoDto getUser(@RequestParam Integer id) {
        return userService.getUser();
    }

}
