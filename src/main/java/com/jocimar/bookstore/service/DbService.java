/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jocimar.bookstore.service;

import com.jocimar.bookstore.domain.Categoria;
import com.jocimar.bookstore.domain.Livro;
import com.jocimar.bookstore.repository.CategoriaRepository;
import com.jocimar.bookstore.repository.LivroRepository;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author F5078775
 */

@Service
public class DbService {
    
    
   @Autowired 
   private CategoriaRepository categoriaRepository;
   
   @Autowired
   private LivroRepository livroRepository;
    
    
    public void instanciaBaseDados(){
        
        
            
            Categoria cat1 = new Categoria(null,"nova categoria do bean","livro de TI");
            
            Livro l1 = new Livro(null,"clean code", "Robert Martin", "Loren ipsun",cat1 );
            
            
            
            categoriaRepository.saveAll(Arrays.asList(cat1));
            livroRepository.saveAll(Arrays.asList(l1));
            

        
        
    }
    
}
