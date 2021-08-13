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
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
    public ResponseEntity<Categoria> listar(@PathVariable Long id) {

        Categoria cat = categoriaRestService.findById(id);

        return ResponseEntity.ok().body(cat);

    }

    @GetMapping("/listar")
    public ResponseEntity<List<CategoriaDto>> listarTodos() {

        List<Categoria> categorias = categoriaRestService.listarCategoriaService();
        List<CategoriaDto> categoriasDto = categorias.stream().map(cat -> new CategoriaDto(cat)).collect(Collectors.toList());

        return ResponseEntity.ok().body(categoriasDto);
    }

    @PostMapping("/add")

    public ResponseEntity<Categoria> add(@RequestBody Categoria categoria) {

        categoria = categoriaRestService.salvarCategoriaRest(categoria);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/categorias/{id}").buildAndExpand(categoria.getId()).toUri();
        //return ResponseEntity.created(uri).build(); // retorna so a uri com o objeto criado
         return ResponseEntity.created(uri).body(categoria); // retorna o objeto ao corpo da resposta
    }


}
