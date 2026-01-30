package com.ece.readinglist.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private int pageCount;
    private String genre;

    private LocalDate startDate;
    private LocalDate endDate;
    private boolean isCompleted;

    // --- BOŞ CONSTRUCTOR ---
    public Book() {
    }

    // --- GETTER VE SETTER METOTLARI (DÜZELTİLMİŞ HALİ) ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) { // Düzeltildi: 'Id' yerine 'id'
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) { // Eklendi!
        this.pageCount = pageCount;
    }

    public String getGenre() { // Eklendi!
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public boolean isCompleted() { // boolean için 'is' kullanılır, doğru.
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}