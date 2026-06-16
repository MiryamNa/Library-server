package com.example.app.DTO;

import com.example.app.model.Book;
import com.fasterxml.jackson.annotation.JsonProperty;

public record AddBookDTO(
        String title,
        String author,
        String image,
        String summary,
        Integer pageCount,
        Long userID
) {}
