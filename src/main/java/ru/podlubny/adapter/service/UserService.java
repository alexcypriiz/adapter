package ru.podlubny.adapter.service;

import ru.podlubny.adapter.dto.UserInfoDto;

public interface UserService {

    UserInfoDto getUser();

    String createUser();
}
