package com.jocimar.bookstore.repository;

import com.jocimar.bookstore.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
