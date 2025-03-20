package ru.podlubny.adapter.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.podlubny.adapter.entity.HolidayEntity;

@Repository
public interface HolidayRepository extends MongoRepository<HolidayEntity, String> {
}
