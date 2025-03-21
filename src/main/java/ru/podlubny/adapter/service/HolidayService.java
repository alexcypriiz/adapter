package ru.podlubny.adapter.service;

import ru.podlubny.adapter.dto.holiday.ContactInfoDto;
import ru.podlubny.adapter.dto.holiday.HolidayDto;
import ru.podlubny.adapter.dto.holiday.HolidayWithContactsDTO;
import ru.podlubny.adapter.dto.user.UserInfoDto;
import ru.podlubny.adapter.entity.HolidayEntity;

import java.util.List;
import java.util.UUID;

public interface HolidayService {
    HolidayDto getHoliday(UUID id);
    List<HolidayEntity> getHoliday();
    UUID createHoliday(HolidayWithContactsDTO holidayWithContactsDTO);
    HolidayDto createPeopleToHoliday(UUID id, List<ContactInfoDto> contactInfoDto);
    List<HolidayDto> getHolidayByUser(UserInfoDto userInfoDto);
}
