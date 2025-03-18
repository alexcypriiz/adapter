package ru.podlubny.adapter.service;

import ru.podlubny.adapter.dto.UserInfoDto;

import java.util.UUID;

public interface UserService {

    UserInfoDto getUser(UUID id);

    UUID createUser(UserInfoDto userInfoDto);
}
