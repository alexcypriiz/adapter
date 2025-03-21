package ru.podlubny.adapter.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.podlubny.adapter.entity.UserEntity;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, String> {
}
