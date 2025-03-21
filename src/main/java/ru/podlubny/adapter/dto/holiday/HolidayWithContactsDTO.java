package ru.podlubny.adapter.dto.holiday;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
public class HolidayWithContactsDTO {
    private String name;

    private String description;

    private LocalDateTime dataEnd;

    private StatusEnum status;

    private List<Question> questions;

    private Set<ContactInfoDto> people;
}
