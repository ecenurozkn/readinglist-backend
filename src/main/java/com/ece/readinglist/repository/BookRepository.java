package com.ece.readinglist.repository;

import com.ece.readinglist.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
    // Bu 'interface' sayesinde Spring Boot;
    // kaydetme, silme, bulma işlerini arka planda kendi halledecek.
}
