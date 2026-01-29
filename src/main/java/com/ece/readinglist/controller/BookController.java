package com.ece.readinglist.controller;

import com.ece.readinglist.entity.Book;
import com.ece.readinglist.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Bu sınıfın bir "Web Servis" olduğunu söyler. (Postman burayla konuşur)
@RequestMapping("/api/books") // Adresimiz: localhost:8080/api/books
public class BookController {

    private final BookService bookService;

    // CONSUMER INJECTION
    // Garson, mutfakla (Service) iletişim kurmak zorunda.
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // 1. KİTAP EKLE (Postman: POST isteği)
    @PostMapping
    public Book addBook(@RequestBody Book book){
        // @RequestBody: Postman'den gelen JSON verisini Book nesnesine çevirir.
        return bookService.saveBook(book);
    }

    // 2. LİSTEYİ GETİR (Postman: GET isteği)
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    // 3. TAMAMLANDI İŞARETLE (Postman: PUT isteği)
    // Örnek kullanım: /api/books/1/complete (1 numaralı kitabı bitirir)
    @PutMapping("/{id}/complete")
    public Book completeBook(@PathVariable Long id) {
        return bookService.markAsCompleted(id);
    }
}
