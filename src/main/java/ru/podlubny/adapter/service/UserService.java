package ru.podlubny.adapter.service;

import ru.podlubny.adapter.dto.user.UserInfoDto;
import ru.podlubny.adapter.entity.UserEntity;

import java.util.List;
import java.util.UUID;

public interface UserService {

    UserInfoDto getUser(UUID id);

    UUID createUser(UserInfoDto userInfoDto);

    UUID updateUser(UserInfoDto userInfoDto, UUID id);

    UUID deleteUser(UUID id);
    List<UserEntity> getUsers();
}
