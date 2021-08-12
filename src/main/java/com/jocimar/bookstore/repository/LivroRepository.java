package com.jocimar.bookstore.repository;


import com.jocimar.bookstore.domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro,Long> {
}
