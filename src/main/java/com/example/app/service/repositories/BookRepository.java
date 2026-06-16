package com.example.app.service.repositories;

import com.example.app.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {

    List<Book> findBooksByTitleContains(String title);
    List<Book> findBooksByAuthor(String author);
    List<Book> findBooksByCategory(String categoryName);
}
