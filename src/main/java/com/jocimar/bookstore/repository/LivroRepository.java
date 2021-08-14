package com.jocimar.bookstore.repository;


import com.jocimar.bookstore.domain.Livro;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LivroRepository extends JpaRepository<Livro,Long> {

    
    @Query("SELECT livro from Livro livro  WHERE livro.categoria.id = :id_categoria order by id")
    public List<Livro> findAllbyCategoria(@Param(value = "id_categoria") Long id_categoria);
}
