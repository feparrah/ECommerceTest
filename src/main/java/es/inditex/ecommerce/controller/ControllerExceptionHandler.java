package es.inditex.ecommerce.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import es.inditex.ecommerce.dto.ErrorResponse;
import es.inditex.ecommerce.exception.BadRequestException;


@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> handleValidationErrors(BadRequestException ex) {
        String error = ex.getMessage();
        ErrorResponse response = new ErrorResponse(error);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ErrorResponse> handleValidationErrors(MissingServletRequestParameterException ex) {
        String error = ex.getMessage();
        ErrorResponse response = new ErrorResponse(error);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
	
	

}