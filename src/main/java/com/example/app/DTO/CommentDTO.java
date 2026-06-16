package com.example.app.DTO;

import java.time.LocalDate;

public record CommentDTO(Long id, String content, LocalDate date,Long bookId) {
}
