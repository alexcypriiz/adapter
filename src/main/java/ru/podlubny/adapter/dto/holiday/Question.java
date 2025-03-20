package ru.podlubny.adapter.dto.holiday;

import lombok.Data;

import java.util.List;

@Data
public class Question {
    private String title;
    private TypeQuestionEnum type;
    private List<String> options;
}
