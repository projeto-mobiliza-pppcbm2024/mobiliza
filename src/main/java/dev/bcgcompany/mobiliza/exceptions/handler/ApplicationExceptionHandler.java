package dev.bcgcompany.mobiliza.exceptions.handler;

import dev.bcgcompany.mobiliza.exceptions.UnauthorizedUserException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ResponseStatus(UNAUTHORIZED)
    @ExceptionHandler
    public ResponseEntity<Void> handle(UnauthorizedUserException exception) {
        return ResponseEntity.status(UNAUTHORIZED).build();
    }
}