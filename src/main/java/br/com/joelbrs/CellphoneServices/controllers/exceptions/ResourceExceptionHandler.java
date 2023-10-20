package br.com.joelbrs.CellphoneServices.controllers.exceptions;

import br.com.joelbrs.CellphoneServices.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        StandardError err = new StandardError();
        HttpStatus status = HttpStatus.NOT_FOUND;

        err.setStatus(status.value());
        err.setPath(request.getRequestURI());
        err.setTimestamp(Instant.now());
        err.setError("Resource Not Found!");

        return ResponseEntity.status(status).body(err);
    }
}
