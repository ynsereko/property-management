package com.mycompany.property_management.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor(force = true)
public class BusinessException extends RuntimeException {

    private final transient  List<ErrorModel> errors;

    public BusinessException(List<ErrorModel> errors) {
        this.errors = errors;
    }
}
