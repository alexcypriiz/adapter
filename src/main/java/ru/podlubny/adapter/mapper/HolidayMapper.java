package ru.podlubny.adapter.mapper;

import org.mapstruct.Mapper;
import ru.podlubny.adapter.dto.holiday.HolidayDto;
import ru.podlubny.adapter.entity.HolidayEntity;

@Mapper
public interface HolidayMapper {

    HolidayDto map(HolidayEntity entity);

    HolidayEntity map(HolidayDto dto);
}
