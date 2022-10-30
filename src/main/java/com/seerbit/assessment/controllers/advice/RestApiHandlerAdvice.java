package com.seerbit.assessment.controllers.advice;

import com.seerbit.assessment.exception.TransactionTimeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class RestApiHandlerAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler({
            TransactionTimeException.class,
    })
    public ResponseEntity<?> restApiHandler(final TransactionTimeException ex) {
        logger.error("API Exception handled {}", ex);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @ExceptionHandler({
            HttpMessageConversionException.class,
    })
    public ResponseEntity<?> restApiHandler2(final HttpMessageConversionException ex) {
        logger.error("API Exception handled {}", ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
