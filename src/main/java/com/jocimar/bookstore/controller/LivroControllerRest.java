/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jocimar.bookstore.controller;

import com.jocimar.bookstore.domain.Categoria;
import com.jocimar.bookstore.domain.Livro;
import com.jocimar.bookstore.dtos.LivroDto;
import com.jocimar.bookstore.service.CategoriaRestService;
import com.jocimar.bookstore.service.LivroRestService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author F5078775
 */

@RequestMapping(value = "livros")
@RestController
public class LivroControllerRest {
  
  @Autowired  
  private LivroRestService livroRestService;    
  
  @Autowired
  private CategoriaRestService categoriaRestService;
    
           @GetMapping("/{id}")
           public ResponseEntity<Livro> listarLivroPorId(@PathVariable Long id){
               
               Livro livro = livroRestService.localizarPorId(id);   
               
               return ResponseEntity.ok().body(livro);
               
               
           }
    
           
         @GetMapping("/livros-por-categoria")  
         public ResponseEntity<List<LivroDto>> listarTodos(@RequestParam(value = "categoria", defaultValue="0") Long id_categoria ){
             
              System.out.println(id_categoria);
             
              
              List<Livro> livros = livroRestService.listarLivrosPorcategoria(id_categoria);
              
              
              List<LivroDto> livrosDto = livros.stream().map(livro -> new LivroDto(livro)).collect(Collectors.toList());

              return ResponseEntity.ok().body(livrosDto);
             
            
             
             
             
         }  
    
           
        
    
    
    
    
}
