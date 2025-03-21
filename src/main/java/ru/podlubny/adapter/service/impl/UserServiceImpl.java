package ru.podlubny.adapter.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.podlubny.adapter.dto.user.UserInfoDto;
import ru.podlubny.adapter.entity.UserEntity;
import ru.podlubny.adapter.mapper.UserInfoMapper;
import ru.podlubny.adapter.repository.UserRepository;
import ru.podlubny.adapter.service.UserService;

import java.util.List;
import java.util.Optional;
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
        log.info("Create user: {}", userInfoDto);
        UserEntity userEntity = userInfoMapper.map(userInfoDto);
        UUID id = UUID.randomUUID();
        userEntity.setId(id.toString());
        userRepository.save(userEntity);
        return id;
    }

    @Override
    public UUID updateUser(UserInfoDto userInfoDto, UUID id) {
        log.info("Update user [{}], [{}] ", id, userInfoDto);
        UserEntity userEntity = userInfoMapper.map(userInfoDto);
        userEntity.setId(id.toString());
        userRepository.save(userEntity);
        return id;
    }

    @Override
    public UUID deleteUser(UUID id) {
        log.info("Delete user [{}]", id);
        userRepository.deleteById(id.toString());
        return id;
    }

    @Override
    public List<UserEntity> getUsers() {
        return Optional.of(userRepository.findAll())
                .orElseThrow(RuntimeException::new);
    }
}
