/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jocimar.bookstore.service;

import com.jocimar.bookstore.domain.Categoria;
import com.jocimar.bookstore.repository.CategoriaRepository;
import com.jocimar.bookstore.service.exceptions.ObjectNotFoundExpection;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author F5078775
 */

@Service
public class CategoriaRestService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    
    public Categoria    findById(Long id){
        
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        
        return categoria.orElseThrow(()-> new ObjectNotFoundExpection("Objeto não encontrado" + id + "Tipo:" + Categoria.class.getName()));
        
    }
    
    
    public List<Categoria> listarCategoriaService(){
        
        return  categoriaRepository.findAll();
        
    }

    public Categoria salvarCategoriaRest(Categoria categoria) {
            categoria.setId(null);
           return categoriaRepository.save(categoria);



    }
    
    
    
}
