package ru.podlubny.adapter.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.podlubny.adapter.dto.holiday.HolidayDto;
import ru.podlubny.adapter.entity.HolidayEntity;
import ru.podlubny.adapter.service.HolidayService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/holiday")
@Slf4j
@RequiredArgsConstructor
public class HolidayController {
    private final HolidayService holidayService;

    @Operation(summary = "Получить событие")
    @GetMapping("/{id}")
    public HolidayDto getHoliday(@PathVariable UUID id) {
        return holidayService.getHoliday(id);
    }

    @Operation(summary = "Добавить новое событие ")
    @PostMapping
    public UUID createHoliday(@RequestBody HolidayDto holidayDto) {
        return holidayService.createHoliday(holidayDto);
    }

    @Operation(summary = "Получить все событие")
    @GetMapping("")
    public List<HolidayEntity> getHoliday() {
        return holidayService.getHoliday();
    }
}
