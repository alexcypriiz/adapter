package ru.podlubny.adapter.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.podlubny.adapter.dto.holiday.ContactInfoDto;
import ru.podlubny.adapter.dto.holiday.HolidayDto;
import ru.podlubny.adapter.dto.holiday.HolidayWithContactsDTO;
import ru.podlubny.adapter.dto.user.UserInfoDto;
import ru.podlubny.adapter.entity.HolidayEntity;
import ru.podlubny.adapter.mapper.HolidayMapper;
import ru.podlubny.adapter.repository.HolidayRepository;
import ru.podlubny.adapter.service.HolidayService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class HolidayServiceImpl implements HolidayService {
    private final HolidayRepository holidayRepository;
    private final HolidayMapper holidayMapper;

    @SneakyThrows
    @Override
    public HolidayDto getHoliday(UUID id) {
        return holidayRepository.findById(String.valueOf(id))
                .map(holidayMapper::map)
                .orElseThrow(Exception::new);
    }

    @Override
    public UUID createHoliday(HolidayWithContactsDTO holidayWithContactsDTO) {
        log.info("Create holiday: [{}]", holidayWithContactsDTO);
        HolidayEntity holidayEntity = holidayMapper.map(holidayWithContactsDTO);
        UUID id = UUID.randomUUID();
        holidayEntity.setId(id.toString());
        holidayRepository.save(holidayEntity);
        return id;
    }

    @Override
    public List<HolidayEntity> getHoliday() {
        return Optional.of(holidayRepository.findAll())
                .orElseThrow(RuntimeException::new);
    }

    @SneakyThrows
    @Override
    public HolidayDto createPeopleToHoliday(UUID id, List<ContactInfoDto> contactInfoDto) {
        HolidayEntity holidayEntity = holidayRepository.findById(String.valueOf(id))
                .orElseThrow(Exception::new);

        holidayEntity.getPeople().addAll(contactInfoDto);
        holidayRepository.save(holidayEntity);

        return holidayMapper.map(holidayEntity);
    }

    @Override
    public List<HolidayDto> getHolidayByUser(UserInfoDto userInfoDto) {
        List<HolidayEntity> holidayEntities = holidayRepository.findByPeopleAndDataEndAfter(
                userInfoDto.getName(),
                userInfoDto.getSurname(),
                userInfoDto.getPhoneNumber());

        return holidayEntities.stream()
                .map(holidayMapper::map)
                .collect(Collectors.toList());
    }
}
