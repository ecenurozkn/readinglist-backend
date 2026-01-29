package com.ece.readinglist.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
@Entity // Bu sınıfn bir veritabanı tablosu olduğunu söylüyor.
@Table(name = "books" ) // Veritabanında tablonun adı 'books' olsun.
public class Book {
    @Id // Bu alanın kimlik numarası (Primary Key) olduğunu belirtir.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID otomatik olarak  artsın (1,2,3..)
    private Long id;

    private String title; //Kitap Adı
    private String author; // Yazar
    private int pageCount; // Sayfa sayısı
    private String genre; // Türü

    private LocalDate startDate; // Başlanan tarih
    private LocalDate endDate; // Bitirilen tarih.
    private boolean isCompleted; // Bitti mi?

    // --- 1. BOŞ CONSTRUCTOR (Zorunlu) ---
    public Book(){
    }
    // --- GETTER VE SETTER METOTLARI ---
    // (Veriye ulaşmak ve değiştirmek için kapılar)
    public Long getId() {return id;}
    public void setId(Long Id) {this.id = id;}

    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}

    public String getAuthor() {return author;}
    public void setAuthor(String author) {this.author = author;}

    public int getPageCount() {return pageCount;}
    public void setGenre(String genre) {this.genre = genre;}

    public LocalDate getStartDate(){return startDate;}
    public void setStartDate(LocalDate startDate) {this.startDate = startDate;}

    public LocalDate getEndDate() {return endDate;}
    public void setEndDate(LocalDate endDate) {this.endDate = endDate;}

    public boolean isCompleted() {return isCompleted;}
    public void setCompleted(boolean completed) {isCompleted = completed;}

}
