/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jocimar.bookstore.dtos;

import com.jocimar.bookstore.domain.Livro;
import java.io.Serializable;

/**
 *
 * @author F5078775
 */
public class LivroDto implements Serializable{
    
    
    private Long id;
    private String titulo;

    public LivroDto() {
        
        super();
    }

    public LivroDto(Livro livro) {
        super();
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    
    
    
}
