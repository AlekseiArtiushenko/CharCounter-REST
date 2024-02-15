package ru.artiushenko.charcounterrest.validation;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ApiErrorResponse {

    private int code;
    private String message;

}
