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
import ru.podlubny.adapter.dto.holiday.ContactInfoDto;
import ru.podlubny.adapter.dto.holiday.HolidayDto;
import ru.podlubny.adapter.dto.holiday.HolidayWithContactsDTO;
import ru.podlubny.adapter.dto.user.UserInfoDto;
import ru.podlubny.adapter.entity.HolidayEntity;
import ru.podlubny.adapter.service.HolidayService;
import ru.podlubny.adapter.service.UserService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/holidays")
@Slf4j
@RequiredArgsConstructor
public class HolidayController {
    private final HolidayService holidayService;
    private final UserService userService;

    @Operation(summary = "Получить событие")
    @GetMapping("/{id}")
    public HolidayDto getHoliday(@PathVariable UUID id) {
        return holidayService.getHoliday(id);
    }

    @Operation(summary = "Добавить новое событие ")
    @PostMapping
    public UUID createHoliday(@RequestBody HolidayWithContactsDTO holidayWithContactsDTO) {
        return holidayService.createHoliday(holidayWithContactsDTO);
    }

    @Operation(summary = "Получить все событие")
    @GetMapping("")
    public List<HolidayEntity> getHoliday() {
        return holidayService.getHoliday();
    }

    @Operation(summary = "Добавить информациию об участниках, для которых будет событие")
    @PostMapping("/{id}/people")
    public HolidayDto addPeopleToHoliday(@PathVariable UUID id,
                                         @RequestBody List<ContactInfoDto> contactInfoDto) {
        return holidayService.createPeopleToHoliday(id, contactInfoDto);
    }

    @Operation(summary = "Получить все события для пользователя")
    @GetMapping("/user/{id}")
    public List<HolidayDto> getHolidayByUser(@PathVariable UUID id){
        UserInfoDto user = userService.getUser(id);
        return holidayService.getHolidayByUser(user);
    }
}
