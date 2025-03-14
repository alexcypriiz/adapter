package ru.podlubny.adapter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class UserInfoDto {
    private String name;

    private String surname;

    private String patronymic;

    private String phoneNumber;

    private String email;

    private String gender;

    private String birthDate;
}
