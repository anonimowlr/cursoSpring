package com.jocimar.bookstore.domain;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Categoria  implements Serializable {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nome;
        private String descricao;

        @OneToMany(mappedBy = "categoria")
        private List<Livro> livros = new ArrayList<>();

}
