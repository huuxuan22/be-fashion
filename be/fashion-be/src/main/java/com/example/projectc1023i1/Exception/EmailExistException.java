package com.example.projectc1023i1.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmailExistException extends RuntimeException {
  public EmailExistException(String message) {
    super(message);
  }
}
