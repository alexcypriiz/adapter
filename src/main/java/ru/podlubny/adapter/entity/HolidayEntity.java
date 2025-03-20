package ru.podlubny.adapter.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.podlubny.adapter.dto.holiday.Question;
import ru.podlubny.adapter.dto.holiday.StatusEnum;

import java.time.LocalDateTime;
import java.util.List;

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
}
