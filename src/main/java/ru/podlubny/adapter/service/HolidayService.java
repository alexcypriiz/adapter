package ru.podlubny.adapter.service;

import ru.podlubny.adapter.dto.holiday.HolidayDto;
import ru.podlubny.adapter.entity.HolidayEntity;

import java.util.List;
import java.util.UUID;

public interface HolidayService {
    HolidayDto getHoliday(UUID id);
    List<HolidayEntity> getHoliday();
    UUID createHoliday(HolidayDto holidayDto);
}
