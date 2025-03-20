package ru.podlubny.adapter.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import ru.podlubny.adapter.dto.holiday.HolidayDto;
import ru.podlubny.adapter.entity.HolidayEntity;
import ru.podlubny.adapter.mapper.HolidayMapper;
import ru.podlubny.adapter.repository.HolidayRepository;
import ru.podlubny.adapter.service.HolidayService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
    public UUID createHoliday(HolidayDto holidayDto) {
        HolidayEntity holidayEntity = holidayMapper.map(holidayDto);
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
}
