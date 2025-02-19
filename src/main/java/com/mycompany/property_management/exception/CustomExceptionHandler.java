package com.mycompany.property_management.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorModel>> handleFieldValidation(MethodArgumentNotValidException maven) {
        List<ErrorModel> errorModelList = new ArrayList<>();
        ErrorModel errorModel = null;
        List<FieldError> fieldErrorList = maven.getBindingResult().getFieldErrors();
        for (FieldError fe : fieldErrorList) {
            logger.debug("Inside field validation: {} - {}",fe.getField(),fe.getDefaultMessage());
            logger.info("Inside field validation: {} - {}",fe.getField(),fe.getDefaultMessage());
            errorModel = new ErrorModel();
            errorModel.setCode(fe.getField());
            errorModel.setMessage(fe.getDefaultMessage());
            errorModelList.add(errorModel);
        }
        return new ResponseEntity<>(errorModelList, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<List<ErrorModel>> handleBusinessException(BusinessException bex) {
        for(ErrorModel em: bex.getErrors()) {
            logger.debug("Business Exception is thrown - level - debug: {} - {}", em.getCode(), em.getMessage());
            logger.info("Business Exception is thrown - level - info: {} - {}",  em.getCode(), em.getMessage());
            logger.warn("Business Exception is thrown - level - warn: {} - {}", em.getCode(), em.getMessage());
            logger.error("Business Exception is thrown - level - error: {} - {}",  em.getCode(), em.getMessage());
        }
        return new ResponseEntity<>(bex.getErrors(), HttpStatus.BAD_REQUEST);
    }
}
