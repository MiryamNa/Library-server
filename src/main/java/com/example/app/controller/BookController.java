package com.example.app.controller;

import com.example.app.DTO.AddBookDTO;
import com.example.app.model.Book;
import com.example.app.model.Category;
import com.example.app.model.Users;
import com.example.app.service.repositories.BookRepository;
import com.example.app.service.repositories.CategoryRepository;
import com.example.app.service.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
@CrossOrigin
public class BookController {
     private final BookRepository bookRepository;
     private final UserRepository userRepository;
     private final CategoryRepository categoryRepository;
     public BookController(BookRepository bookRepository, UserRepository userRepository, CategoryRepository categoryRepository){
         this.bookRepository=bookRepository;
         this.userRepository = userRepository;
         this.categoryRepository = categoryRepository;
     }

    @GetMapping("/getBooks")
    public ResponseEntity<List<Book>> getBooks(){
        try{
            return new ResponseEntity<>(bookRepository.findAll(), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }
    @PostMapping("/addBook")
    public ResponseEntity<?> addBook(@RequestBody AddBookDTO request) {
        System.out.println("UserID = " + request.userID());
        Optional<Users> userOpt = userRepository.findById(request.userID());
        if (userOpt.isEmpty() || !userOpt.get().isStatus()) {
            return ResponseEntity.status(403).body("Not authorized");
        }


        Book book = new Book();
        book.setTitle(request.title());
        book.setAuthor(request.author());
        book.setImage(request.image());
        book.setSummary(request.summary());
//        book.setPageCount(request.pageCount());


        bookRepository.save(book);
        return ResponseEntity.ok(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        return bookRepository.findById(id)
                .map(book -> {
                    book.setTitle(updatedBook.getTitle());
                    book.setAuthor(updatedBook.getAuthor());
                    book.setCategory(updatedBook.getCategory());
                    return bookRepository.save(book);
                })
                .orElseGet(() -> {
                    updatedBook.setId(id);
                    return bookRepository.save(updatedBook);
                });
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
    }




}
