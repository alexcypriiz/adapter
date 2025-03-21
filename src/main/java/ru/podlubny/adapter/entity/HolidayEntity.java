package ru.podlubny.adapter.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.podlubny.adapter.dto.holiday.ContactInfoDto;
import ru.podlubny.adapter.dto.holiday.Question;
import ru.podlubny.adapter.dto.holiday.StatusEnum;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@Document
public class HolidayEntity {
    @Id
    private String id;

    private String name;

    private String description;

    private LocalDateTime dataEnd;

    private StatusEnum status;

    private List<Question> questions;

    private Set<ContactInfoDto> people;
}
