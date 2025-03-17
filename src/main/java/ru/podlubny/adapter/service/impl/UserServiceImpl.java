package ru.podlubny.adapter.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.podlubny.adapter.dto.UserInfoDto;
import ru.podlubny.adapter.entity.UserEntity;
import ru.podlubny.adapter.mapper.UserInfoMapper;
import ru.podlubny.adapter.service.UserService;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserInfoMapper userInfoMapper;

    @Override
    public UserInfoDto getUser() {

        UserEntity userEntity = UserEntity.builder().name("Anton")
                .surname("Антонов")
                .patronymic("Antonovich")
                .phoneNumber("9030223773")
                .email("pisya@yandex.ru")
                .gender("M")
                .birthDate("25041997")
                .build();


        return userInfoMapper.map(userEntity);
    }

    @Override
    public String createUser() {
        return null;
    }
}
