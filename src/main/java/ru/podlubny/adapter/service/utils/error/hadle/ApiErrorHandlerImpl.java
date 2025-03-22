package ru.podlubny.adapter.service.utils.error.hadle;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.podlubny.adapter.api.handler.error.ApiError;
import ru.podlubny.adapter.api.handler.error.ApiException;

import static java.lang.String.format;

@Slf4j
@Service
public class ApiErrorHandlerImpl implements ApiErrorHandler {

    @Override
    public ResponseEntity<ApiError> handle(Exception ex, HttpServletRequest request) {
        if (ex instanceof ApiException) {
            return buildErrorResponse((ApiException) ex);
        }
        return buildDefaultErrorResponse(ex);
    }

    private boolean isInternalServerError(ApiException apiException) {
        return HttpStatus.INTERNAL_SERVER_ERROR.equals(apiException.getError().getHttpStatus());
    }

    private ResponseEntity<ApiError> buildErrorResponse(ApiException apiException) {
        int code = apiException.getError().getCode();
        String message = apiException.getError().getMessage();
        if (isInternalServerError(apiException)) {
            message = getDefaultErrorMessage(message, code, apiException);
        } else {
            log.warn("Caught external error with message: {}", apiException.getMessage(), apiException);
        }
        ApiError apiError = new ApiError(message, code);
        return new ResponseEntity<>(apiError, apiException.getError().getHttpStatus());
    }

    private ResponseEntity<ApiError> buildDefaultErrorResponse(Exception exception) {
        int code = HttpStatus.INTERNAL_SERVER_ERROR.value();
        String message = getDefaultErrorMessage(exception.getMessage(), code, exception);
        ApiError error = new ApiError(message, code);
        return new ResponseEntity<>(error, null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private String getDefaultErrorMessage(String message, int code, Exception exception) {
        String errorId = RandomStringUtils.randomNumeric(8);
        log.error("ErrorId={}. Message={} ErrorCode={}", errorId, message, code, exception);
        return format("Internal server error. Please contact administrator with errorId=%s", errorId);
    }
}
