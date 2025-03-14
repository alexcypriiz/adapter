package ru.podlubny.adapter.mapper;

import org.mapstruct.Mapper;
import ru.podlubny.adapter.dto.UserInfoDto;
import ru.podlubny.adapter.entity.UserEntity;

@Mapper
public interface UserInfoMapper {
    UserInfoDto map(UserEntity userEntity);
}
