package com.example.app.controller;

import com.example.app.DTO.LendDTO;
import com.example.app.model.Book;
import com.example.app.model.Lend;
import com.example.app.model.Users;
import com.example.app.service.repositories.BookRepository;
import com.example.app.service.repositories.LendRepository;
import com.example.app.service.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/lend")
@CrossOrigin(origins = "*")
public class LendController {

    private final LendRepository lendRepository;

    @Autowired
    private UserRepository usersRepository;

    @Autowired
    private BookRepository bookRepository;

    public LendController(LendRepository lendRepository) {
        this.lendRepository = lendRepository;
    }

    @GetMapping("/{id}")
    public Optional<Lend> getLendById(@PathVariable Long id) {

        return lendRepository.findById(id);
    }

    @GetMapping
    public List<Lend> getAllLends() {
        return lendRepository.findAll();
    }

    @PostMapping("/lendBook")
    public ResponseEntity<?> lendBook(@RequestBody LendDTO dto) {
        Optional<Users> userOpt = usersRepository.findById(dto.userId());
        Optional<Book> bookOpt = bookRepository.findById(dto.bookId());

        if (userOpt.isEmpty() || bookOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("User or Book not found");
        }

        Users user = userOpt.get();
        Book book = bookOpt.get();

        // יוצרים רשומת השאלה
        Lend lend = new Lend();
        lend.setUser(user);
        lend.setBook(book);
        lend.setLendingDate(LocalDate.now());

        lendRepository.save(lend);

        return ResponseEntity.ok(lend);
    }
}

