/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jocimar.bookstore.config;

import com.jocimar.bookstore.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 *
 * @author F5078775
 */

@Configuration
@Profile("dev")
public class DevConfig {
    
    @Autowired
    private DbService dbService;
    
    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String strategy;
    
    
    @Bean
    public boolean instanciarBase(){
        
        
        if(strategy.equals("create")){
            
            this.dbService.instanciaBaseDados();
            
        }
        
        
        return false;
        
        
        
    }
    
    
    
    
}
