package com.example.app.service.mappers;

import com.example.app.DTO.BookDTO;
import com.example.app.model.Book;
import org.mapstruct.Mapper;


import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookDTO toDTO(Book b);
    Book toBook(BookDTO bookDTO);
    List<BookDTO> bookDTO(List<Book> bookList);
}
