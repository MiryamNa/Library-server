package com.example.app.controller;
import com.example.app.DTO.CommentDTO;
import com.example.app.service.mappers.CommentMapper;
import com.example.app.model.Comment;
import com.example.app.service.repositories.CommentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/comments")
@CrossOrigin(origins = "*")
public class CommentController {

    private final CommentRepository commentRepository;

    public CommentController(CommentRepository commentRepository) {

        this.commentRepository = commentRepository;
    }

    @GetMapping("getCommentsById/{id}")
    public ResponseEntity<List<Comment>> getCommentById(@PathVariable long id) {
        try {
            List<Comment>c = commentRepository.findCommentsByBookId(id);
            if (c.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(c, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @PostMapping
    public Comment createComment(@RequestBody Comment comment) {
        return commentRepository.save(comment);
    }

    @PutMapping("/{id}")
    public Comment updateComment(@PathVariable Long id, @RequestBody Comment updatedComment) {
        return commentRepository.findById(id)
                .map(comment -> {
                    comment.setContent(updatedComment.getContent());
                    comment.setBook(updatedComment.getBook());
                    comment.setUser(updatedComment.getUser());
                    return commentRepository.save(comment);
                })
                .orElseGet(() -> {
                    updatedComment.setId(id);
                    return commentRepository.save(updatedComment);
                });
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Long id) {
        commentRepository.deleteById(id);
    }
}
