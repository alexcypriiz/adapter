package ru.podlubny.adapter.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.podlubny.adapter.dto.UserInfoDto;
import ru.podlubny.adapter.service.UserService;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/users")
@Slf4j
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(summary = "Получение информации по пользовалю")
    @GetMapping("/{id}")
    public UserInfoDto getUser(@PathVariable UUID id) {
        return userService.getUser(id);
    }

    @Operation(summary = "Добавить нового пользователя")
    @PostMapping()
    public UUID createUser(@RequestBody UserInfoDto userInfoDto) {
        return userService.createUser(userInfoDto);
    }
}
