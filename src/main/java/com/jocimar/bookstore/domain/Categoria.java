package com.jocimar.bookstore.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data

public class Categoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;

    @OneToMany(mappedBy = "categoria",fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Livro> livros = new ArrayList<>();

    public Categoria() {
    }

    public Categoria(Long id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

}
