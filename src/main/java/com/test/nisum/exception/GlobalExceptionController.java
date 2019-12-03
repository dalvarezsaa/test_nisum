package com.test.nisum.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.test.nisum.enums.TipoErrorEnum;
import com.test.nisum.response.GenericResponse;

/**
 * Clase controller encargada de mapear los errores globales.
 * 
 * @version 1.0 25/11/2019
 */
@ControllerAdvice
public class GlobalExceptionController {


    /**
     * Atributo para obtener los mensajes.
     */
    private transient MessageSource messageSource;

    public MessageSource getMessageSource() {
        return messageSource;
    }

    @Autowired
    public void setMessageSource( MessageSource messageSource ) {
        this.messageSource = messageSource;
    }

    
    @ExceptionHandler(org.springframework.http.converter.HttpMessageNotReadableException.class)
    public ResponseEntity<GenericResponse>  errorFormat(Exception ex){
    	GenericResponse genericResponse = new GenericResponse();
    	ResponseEntity<GenericResponse> response = null;
    	
		genericResponse.setMessage(TipoErrorEnum.MENSAJE_ERROR_FORMATO.getNombre());
		
		response = new ResponseEntity<>(genericResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    	return response;
    }
}
