📚 Reading List Backend
Kişisel kitap okuma takibimi yapmak, okunan ve okunacak kitapları listelemek için geliştirdiğim RESTful API projesi. Bu proje, kitap ekleme, güncelleme ve listeleme işlemlerini yöneten bir backend servisidir.

🚀 Canlı Demo (Live)
Proje şu an Railway üzerinde yayındadır: 👉 Base URL: https://readinglist-backend-production.up.railway.app

🛠️ Teknolojiler
Bu projeyi geliştirirken kullandığım güncel teknolojiler:

Java 21 - Programlama Dili

Spring Boot 3 - Web Framework

PostgreSQL - Veritabanı (Railway üzerinde)

Maven - Bağımlılık Yönetimi

Hibernate / JPA - ORM (Veritabanı İlişkilendirme)

Railway - Cloud Deployment (Bulut Sunucu)

✨ Özellikler
📖 Kitap Listeleme: Veritabanındaki tüm kitapları getirir.

➕ Kitap Ekleme: Listeye yeni bir kitap ekler.

🔍 Detay Görüntüleme: ID numarasına göre tek bir kitabın detaylarını getirir.

✅ Tamamlandı İşaretleme: Okunan bir kitabı "bitti" olarak günceller.

🤖 Otomatik Veri Yükleyici: Uygulama ilk açıldığında test amaçlı 100 adet örnek kitap verisi yükler (Data Loader).

🔌 API Dokümantasyonu (Endpoints)
Postman veya tarayıcı kullanarak aşağıdaki adreslere istek atabilirsiniz:

1. Tüm Kitapları Getir

Veritabanındaki kayıtlı kitap listesini döner.

Method: GET

URL: /api/books

2. Tek Bir Kitabı Getir

Belirli bir ID'ye sahip kitabı getirir.

Method: GET

URL: /api/books/{id}

Örnek: /api/books/15

3. Yeni Kitap Ekle

Listeye yeni kitap ekler.

Method: POST

URL: /api/books

Body (JSON):

JSON
{
"title": "Simyacı",
"author": "Paulo Coelho",
"pageCount": 188,
"genre": "Roman"
}
4. Kitabı "Okundu" Olarak İşaretle

Kitabın durumunu günceller.

Method: PUT

URL: /api/books/{id}/complete

💻 Kurulum (Local'de Çalıştırma)
Projeyi kendi bilgisayarınızda çalıştırmak isterseniz:

Projeyi klonlayın:

Bash
git clone https://github.com/KULLANICI_ADIN/readinglist-backend.git
Proje dizinine gidin:

Bash
cd readinglist-backend
application.properties dosyasında kendi yerel veritabanı (PostgreSQL) bilgilerinizi girin.

Uygulamayı başlatın:

Bash
./mvnw spring-boot:run

👤 İletişim
Ece Nur Özkan

LinkedIn: www.linkedin.com/in/ece-nur-ozkan

Medium: https://medium.com/@ecenurozk