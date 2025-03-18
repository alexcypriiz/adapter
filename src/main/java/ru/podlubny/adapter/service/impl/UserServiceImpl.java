package ru.podlubny.adapter.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.podlubny.adapter.dto.UserInfoDto;
import ru.podlubny.adapter.entity.UserEntity;
import ru.podlubny.adapter.mapper.UserInfoMapper;
import ru.podlubny.adapter.repository.UserRepository;
import ru.podlubny.adapter.service.UserService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserInfoMapper userInfoMapper;
    private final UserRepository userRepository;

    @SneakyThrows
    @Override
    public UserInfoDto getUser(UUID id) {

        return userRepository.findById(String.valueOf(id))
                .map(userInfoMapper::map)
                .orElseThrow(Exception::new);
    }

    @Override
    public UUID createUser(UserInfoDto userInfoDto) {
        UserEntity userEntity = userInfoMapper.map(userInfoDto);
        UUID id = UUID.randomUUID();
        userEntity.setId(id.toString());
        userRepository.save(userEntity);
        return id;
    }
}
