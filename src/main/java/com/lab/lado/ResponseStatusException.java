package com.lab.lado;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Not found page")
public class ResponseStatusException extends Exception {
    public String error() {
        return "Error!";
    }
}
