package ru.podlubny.adapter.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import ru.podlubny.adapter.entity.HolidayEntity;

import java.util.List;

@Repository
public interface HolidayRepository extends MongoRepository<HolidayEntity, String> {

    @Query("{ '$or': [ " +
            "{ 'people.name': ?0, 'people.surname': ?1, 'people.phone': ?2, 'dataEnd': { $gt: new Date() } }, " +
            "{ 'people': { $size: 0 } } " +
            "] }")
    List<HolidayEntity> findByPeopleAndDataEndAfter(
            String name,
            String surname,
            Long phone);
}
