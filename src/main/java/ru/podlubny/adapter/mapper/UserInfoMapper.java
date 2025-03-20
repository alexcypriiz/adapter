package ru.podlubny.adapter.mapper;

import org.mapstruct.Mapper;
import ru.podlubny.adapter.dto.user.UserInfoDto;
import ru.podlubny.adapter.entity.UserEntity;

@Mapper
public interface UserInfoMapper {
    UserInfoDto map(UserEntity userEntity);
    UserEntity map(UserInfoDto userInfoDto);
}
