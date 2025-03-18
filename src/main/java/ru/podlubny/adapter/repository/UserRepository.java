package ru.podlubny.adapter.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.podlubny.adapter.entity.UserEntity;

public interface UserRepository extends MongoRepository<UserEntity, String> {
}
