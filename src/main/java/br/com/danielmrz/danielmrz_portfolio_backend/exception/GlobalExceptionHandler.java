package br.com.danielmrz.danielmrz_portfolio_backend.exception;

import br.com.danielmrz.danielmrz_portfolio_backend.dto.DefaultErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

  public ResponseEntity<DefaultErrorResponse> buildResponse(String message, HttpStatus status) {
    DefaultErrorResponse error = new DefaultErrorResponse(
      message,
      status.value(),
      LocalDateTime.now()
    );
    return ResponseEntity.status(status).body(error);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<DefaultErrorResponse> handleNotMappedException(Exception e) {
    return buildResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(ProjectNotFoundException.class)
  public ResponseEntity<DefaultErrorResponse> projectNotFoundException(ProjectNotFoundException e) {
    return buildResponse(e.getMessage(), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(ProjectAlreadyExistsException.class)
  public ResponseEntity<DefaultErrorResponse> projectAlreadyExists(ProjectAlreadyExistsException e) {
    return buildResponse(e.getMessage(), HttpStatus.CONFLICT);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<DefaultErrorResponse> handleValidationException(MethodArgumentNotValidException e) {
    String message = e.getBindingResult()
      .getFieldErrors()
      .stream()
      .map(error -> error.getField() + ": " + error.getDefaultMessage())
      .collect(Collectors.joining(", "));
    return buildResponse(message, HttpStatus.BAD_REQUEST);
  }
}
