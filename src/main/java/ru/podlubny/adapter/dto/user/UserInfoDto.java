package ru.podlubny.adapter.dto.user;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserInfoDto {
    private String name;

    private String surname;

    private String patronymic;

    private Long phoneNumber;

    private String email;

    private GenderEnum gender;

    private LocalDate birthDate;
}
