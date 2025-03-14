package ru.podlubny.adapter.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserEntity {
    private String name;

    private String surname;

    private String patronymic;

    private String phoneNumber;

    private String email;

    private String gender;

    private String birthDate;
}
