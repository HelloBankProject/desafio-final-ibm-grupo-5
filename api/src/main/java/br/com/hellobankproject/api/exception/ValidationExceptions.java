package br.com.hellobankproject.api.exception;

import java.time.LocalDateTime;
import java.util.Map;

public class ValidationExceptions {

    private final Map<String, String> erros;
    private final long statusCode;
    private final String statusName;
    private final LocalDateTime timestamp;

    public ValidationExceptions(Map<String, String> erros, long statusCode, String statusName,
            LocalDateTime timestamp) {
        this.erros = erros;
        this.statusCode = statusCode;
        this.statusName = statusName;
        this.timestamp = timestamp;
    }

    public Map<String, String> getErros() {
        return erros;
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