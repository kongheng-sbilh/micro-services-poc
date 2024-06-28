package kh.com.sbilhbank.integration.error;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class RestClientCustomException extends Exception {

    public RestClientCustomException(String message) {
        super(message);
    }

    public RestClientCustomException(Throwable cause) {
        super(cause);
    }

    public RestClientCustomException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
