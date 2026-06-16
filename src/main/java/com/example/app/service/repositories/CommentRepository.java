package com.example.app.service.repositories;

import com.example.app.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findCommentsByBookId(Long bookId);

    List<Comment> findCommentsByUser_UserName(String userName);}
