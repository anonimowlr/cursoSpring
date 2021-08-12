package com.jocimar.bookstore.domain;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;


@Entity
@Data


public class Livro implements  Serializable{
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String nomeAutor;
    private String texto;

    @ManyToOne
    @JoinColumn(name = "categoria_id", referencedColumnName = "id")
    private Categoria categoria;

    public Livro() {
    }

    public Livro(Long id, String titulo, String nomeAutor, String texto, Categoria categoria) {
        this.id = id;
        this.titulo = titulo;
        this.nomeAutor = nomeAutor;
        this.texto = texto;
        this.categoria = categoria;
    }
    
    
    
    

}
