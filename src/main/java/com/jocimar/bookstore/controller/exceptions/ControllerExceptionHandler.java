/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jocimar.bookstore.controller.exceptions;

import com.jocimar.bookstore.service.exceptions.ErroIntegridade;
import com.jocimar.bookstore.service.exceptions.ObjectNotFoundExpection;
import javax.servlet.ServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author F5078775
 */


@ControllerAdvice
public class ControllerExceptionHandler {
    
    
    @ExceptionHandler(ObjectNotFoundExpection.class)
    public ResponseEntity<StandardError> objectNotFoudException(ObjectNotFoundExpection e, ServletRequest request){
        
        StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), e.getMessage());
        
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        
    }
    
    
     @ExceptionHandler(ErroIntegridade.class)
    public ResponseEntity<StandardError> erroIntegridade(ErroIntegridade e, ServletRequest request){
        
        StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), e.getMessage());
        
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        
    }
    
}
