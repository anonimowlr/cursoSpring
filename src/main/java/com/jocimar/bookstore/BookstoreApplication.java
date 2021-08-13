package com.jocimar.bookstore;

import com.jocimar.bookstore.domain.Categoria;
import com.jocimar.bookstore.domain.Livro;
import com.jocimar.bookstore.repository.CategoriaRepository;
import com.jocimar.bookstore.repository.LivroRepository;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner{
    
   @Autowired 
   private CategoriaRepository categoriaRepository;
   
   @Autowired
   private LivroRepository livroRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {

//            Categoria cat1 = new Categoria(null,"informática","livro de TI");
//            
//            Livro l1 = new Livro(null,"clean code", "Robert Martin", "Loren ipsun",cat1 );
//            
//            
//            
//            categoriaRepository.saveAll(Arrays.asList(cat1));
//            livroRepository.saveAll(Arrays.asList(l1));
            

    }

}
