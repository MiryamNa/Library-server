package com.example.app.service.mappers;

import com.example.app.DTO.CommentDTO;
import com.example.app.model.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    @Mapping(source = "book.id",target = "bookId")
    CommentDTO toDTO(Comment comment);
    Comment toComment(CommentDTO CommentDTO);

    List<CommentDTO> toDTO(List<Comment> comments);

}
