package com.jocimar.bookstore;

import com.jocimar.bookstore.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookstoreApplication {

    @Autowired
    private DbService dbService;

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }

}
