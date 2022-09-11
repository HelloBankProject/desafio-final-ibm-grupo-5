package br.com.hellobankproject.api.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.support.WebExchangeBindException;

@ControllerAdvice
public class Exceptionhandle {

    @ResponseBody
    @ExceptionHandler(WebExchangeBindException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ValidationExceptions error(WebExchangeBindException e) {

        Map<String, String> erros = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(error -> erros.put(error.getField(), error.getDefaultMessage()));

        return new ValidationExceptions(erros, HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(),
                LocalDateTime.now());
    }
}
