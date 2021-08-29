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
public class LivroRestService {
    
    @Autowired
    private LivroRepository livroRepository;
    
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    @Autowired
    private CategoriaRestService categoriaRestService;

   
    
    
    
    public Livro localizarPorId(Long id) {

       
        Optional<Livro> livro = livroRepository.findById(id);
        
        return livro.orElseThrow(()-> new ObjectNotFoundExpection("Livro não encontrado"));
        
       
        
      

    }

    public List<Livro> listarLivrosPorcategoria(Long id_categoria) {
        
       categoriaRestService.localizaCategoriaPorIdRest(id_categoria);

     return livroRepository.findAllbyCategoria(id_categoria);
        
     

    }

   
    
}
