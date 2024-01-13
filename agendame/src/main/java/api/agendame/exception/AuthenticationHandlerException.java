package api.agendame.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class AuthenticationHandlerException extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {AuthenticationException.class})
    protected ResponseEntity<Object> authenticationHandlerException(AuthenticationException authenticationException) {
        return new ResponseEntity<>(authenticationException, new HttpHeaders(), authenticationException.getHttpStatus());
    }
}
