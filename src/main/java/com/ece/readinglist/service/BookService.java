package com.ece.readinglist.service;

import com.ece.readinglist.entity.Book;
import com.ece.readinglist.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service // Spring'e "Nu sınıf iş mantığını yönetir" diyoruz.
public class BookService {

    private final BookRepository bookRepository;

    // CONSUMER INJECTION
    // Service, çalışmak için Repository'e muhtaçtır.
    //Burada "Bana bir repo verin yoksa çalışmam" diyoruz.

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // 1. KİTAP EKLEME METODU
    public Book saveBook(Book book){
        // Kural: eğer kullanıcı başlama tarihi girmediyse, otomatik bugün yap.
        if (book.getStartDate() == null) {
            book.setStartDate(LocalDate.now());
        }
        // Kural: Yeni eklenen kitap henüz bitmemiştir.
        if (book.isCompleted()) {
            // Kullanıcı yanlışlıkla bitti işaretlese bile başlangıçta false yapabiliriz.
            // Ama şimdilik olduğu gibi bırakalım.
        }
        return bookRepository.save(book);
    }

    // 2. TÜM KİTAPLARI LİSTELEME
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    // 3. "TAMAMLANDI" BUTONUNA BASILINCA ÇALIŞACAK MANTIK
    public Book markAsCompleted(long id) {
        // Önce kitabı veritabanında bulalım.
        Optional<Book> foundBook = bookRepository.findById(id);

        if (foundBook.isPresent()) {
            Book book = foundBook.get(); // Kitabı kutudan çıkar.

            book.setCompleted(true);    // Durumu "bitti" yap.
            book.setEndDate(LocalDate.now());  // Bitiş tarihini "bugün" yap.

        return bookRepository.save(book); // Güncellenmiş haliyle tekrar kaydet.
        }
        else {
            throw new RuntimeException("aradığınız ID'ye ait kitap bulunamadı!");
        }
    }
}

