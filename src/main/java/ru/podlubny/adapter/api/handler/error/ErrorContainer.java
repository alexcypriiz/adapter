package ru.podlubny.adapter.api.handler.error;

import org.springframework.http.HttpStatus;

public interface ErrorContainer {
    String getMessage();
    int getCode();
    HttpStatus getHttpStatus();
}
