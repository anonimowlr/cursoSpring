/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jocimar.bookstore.controller;

import com.jocimar.bookstore.domain.Categoria;
import com.jocimar.bookstore.dtos.CategoriaDto;
import com.jocimar.bookstore.repository.CategoriaRepository;
import com.jocimar.bookstore.service.CategoriaRestService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author F5078775
 */

@RestController
@RequestMapping(value = "categorias")
public class CategoriaControllerRest {
   
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    @Autowired
    private CategoriaRestService categoriaRestService;
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> listar(@PathVariable Long id){
        
        Categoria cat = categoriaRestService.findById(id);
        
        return ResponseEntity.ok().body(cat);
        
    } 
    
    
    @GetMapping("/listar")
    public ResponseEntity<List<CategoriaDto>> listarTodos(){
        
        List<Categoria> categorias = categoriaRestService.listarCategoriaService();
        List<CategoriaDto> categoriasDto =  categorias.stream().map(cat -> new CategoriaDto(cat)).collect(Collectors.toList());
        
        
        
        return ResponseEntity.ok().body(categoriasDto);
    }
    
}
