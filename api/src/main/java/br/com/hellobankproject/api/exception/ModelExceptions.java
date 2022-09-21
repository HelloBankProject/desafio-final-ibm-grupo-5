package br.com.hellobankproject.api.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ModelExceptions {

  private String error;
  private final long statusCode = HttpStatus.BAD_REQUEST.value();
  private final String statusName = HttpStatus.BAD_REQUEST.name();
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
  private final LocalDateTime timestamp = LocalDateTime.now();

  public ModelExceptions(String error) {
    this.error = error;
  }

  public String getErro() {
    return error;
  }

  public long getStatusCode() {
    return statusCode;
  }

  public String getStatusName() {
    return statusName;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }

}
