package ru.podlubny.adapter.api.handler.error;

import jakarta.servlet.http.HttpServletRequest;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.podlubny.adapter.service.utils.error.hadle.ApiErrorHandler;

@EqualsAndHashCode(callSuper = true)
@ControllerAdvice
@RequiredArgsConstructor
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    private final ApiErrorHandler apiErrorHandler;

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity generalHandler(Exception ex, HttpServletRequest request) {
        return apiErrorHandler.handle(ex, request);
    }
}
