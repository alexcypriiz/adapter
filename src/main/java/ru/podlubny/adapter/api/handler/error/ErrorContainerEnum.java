package ru.podlubny.adapter.api.handler.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorContainerEnum implements ErrorContainer {
    HOLIDAY_NOT_FOUND(4001, "Holiday not found", HttpStatus.NOT_FOUND),
    USER_NOT_FOUND(4002, "User not found", HttpStatus.NOT_FOUND),
    OTHER(999, "Other Type of Error. See error message", HttpStatus.INTERNAL_SERVER_ERROR);

    private int code;
    private String message;
    private HttpStatus httpStatus;
}
