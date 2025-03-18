package ru.podlubny.adapter.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.podlubny.adapter.dto.GenderEnum;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Document
public class UserEntity {

    @Id
    private String id;

    private String name;

    private String surname;

    private String patronymic;

    private Long phoneNumber;

    private String email;

    private GenderEnum gender;

    private LocalDateTime birthDate;


}
