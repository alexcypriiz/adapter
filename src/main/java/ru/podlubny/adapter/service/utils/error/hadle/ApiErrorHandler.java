package ru.podlubny.adapter.service.utils.error.hadle;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import ru.podlubny.adapter.api.handler.error.ApiError;
import ru.podlubny.adapter.api.handler.error.ApiException;

public interface ApiErrorHandler {
    ResponseEntity<ApiError> handle(Exception ex, HttpServletRequest request);
}
