package ru.podlubny.adapter.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.podlubny.adapter.dto.user.UserInfoDto;
import ru.podlubny.adapter.entity.UserEntity;
import ru.podlubny.adapter.service.UserService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/users")
@Slf4j
@RequiredArgsConstructor
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

    @Operation(summary = "Изменить пользователя")
    @PutMapping("/{id}")
    public UUID updateUser(@RequestBody UserInfoDto userInfoDto, @PathVariable UUID id) {

         return userService.updateUser(userInfoDto, id);
    }

    @Operation(summary = "Удалить пользователя")
    @DeleteMapping("/{id}")
    public UUID deleteUser(@PathVariable UUID id) {

        return userService.deleteUser(id);
    }

    @Operation(summary = "Получение информации по всем пользователям")
    @GetMapping("")
    public List<UserEntity> getUsers() {
        return userService.getUsers();
    }
}
