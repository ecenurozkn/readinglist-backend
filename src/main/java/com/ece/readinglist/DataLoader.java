package com.ece.readinglist;

import com.ece.readinglist.entity.Book;
import com.ece.readinglist.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component // Bu, Spring Boot'a "Başlarken beni de çalıştır der."
public class DataLoader implements CommandLineRunner {

    private final BookRepository bookRepository;
    public DataLoader(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Önce veritabanına bakılısın, kitap zaten varsa tekrar eklemeyelim.
        if (bookRepository.count() == 0) {
            System.out.println("--- Veritabanı boş, 100 kitap yükleniyor...---");

            List<Book> kutuphane = new ArrayList<>();
            Random random = new Random();

            String[] turler = {"Roman", "Bilim Kurgu", "Tarih", "Kişisel Gelişim", "Fantastik"};
            String[] yazarlar = {"Ahmet Ümit", "J.K. Rowling", "Dan Brown", "Stephen King", "Elif Şafak"};

            // 1'den 100'e kadar döngü
            for (int i = 1; i <= 100; i++) {
                Book b = new Book();
                b.setTitle("Efsane Kitap Serisi - Cilt " + i);
                b.setAuthor(yazarlar[random.nextInt(yazarlar.length)]); // Rastgele yazar seç
                b.setGenre(turler[random.nextInt(turler.length)]); // Rastgele tür seç
                b.setPageCount(100 + random.nextInt(900)); // 100 ile 1000 arası rastgele sayfa
                b.setCompleted(random.nextBoolean()); // Rastgele okundu/okunmadı yap

                kutuphane.add(b);
            }
            // Hepsini tek seferde kaydet
            bookRepository.saveAll(kutuphane);

            System.out.println("--- 100 Kitap Başarıyla Eklendi! --- ");
        }
        else {
            System.out.println("--- Veritabanında zaten kitaplar var, ekleme yapılmadı. --- ");
        }
    }
}
