package kh.com.sbilhbank.integration.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RestClientCustomException.class)
    public ResponseEntity<ErrorMessage> restClientCustomException(RestClientCustomException restClientCustomException) {
        HttpStatus statusCode = (HttpStatus) ((HttpClientErrorException) restClientCustomException.getCause()).getStatusCode();
        ErrorMessage errorMessage = new ErrorMessage(statusCode, restClientCustomException.getMessage());
        return ResponseEntity
            .status(statusCode)
            .body(errorMessage);
    }
}
