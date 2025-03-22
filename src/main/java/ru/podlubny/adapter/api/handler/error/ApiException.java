package ru.podlubny.adapter.api.handler.error;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ApiException extends RuntimeException {
    private String message;
    private ErrorContainer error;

    public ApiException(ErrorContainer error) {
        this.message = error.getMessage();
        this.error = error;
    }
}
