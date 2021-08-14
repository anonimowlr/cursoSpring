/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jocimar.bookstore.service.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

/**
 *
 * @author F5078775
 */
@Service
@Data
@AllArgsConstructor
public class ErroIntegridade extends RuntimeException{

    public ErroIntegridade(String message) {
        super(message);
    }

    public ErroIntegridade(String message, Throwable cause) {
        super(message, cause);
    }
    
    
    
        
    
}
