package com.ilker.secondhand.exception;

import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Controller
public class GenericExceptionHandler extends ResponseEntityExceptionHandler {
@NotNull
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
  Map<String,String> errors = new HashMap<>();
  ex.getBindingResult().getAllErrors().forEach(error -> {
    String fieldName = ((FieldError) error).getField();
    String errorMessage = error.getDefaultMessage();
    errors.put(fieldName, errorMessage);
  });
  return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
}
@ExceptionHandler(UserNotFoundException.class)
  public ResponseEntity<?> CustomerNotFoundExceptionHandler(UserNotFoundException exception){
  return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
}
@ExceptionHandler(Exception.class)
  public ResponseEntity<?> generalExceptionHandler(Exception exception) {
  return new ResponseEntity<>(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
}
}
