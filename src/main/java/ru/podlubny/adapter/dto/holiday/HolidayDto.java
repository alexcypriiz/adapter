package ru.podlubny.adapter.dto.holiday;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class HolidayDto {

    private String name;

    private String description;

    private LocalDateTime dataEnd;

    private StatusEnum status;

    private List<Question> questions;
}
