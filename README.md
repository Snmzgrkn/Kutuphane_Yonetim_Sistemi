# Kütüphane Yönetim Sistemi - REST API

Bu proje, kitapların, yazarların, kategorilerin, yayınevlerinin ve ödünç alma işlemlerinin yönetimini sağlamak amacıyla geliştirilmiş bir Kütüphane Yönetim Sistemi REST API'sidir. Proje, Spring Boot kullanılarak oluşturulmuş ve PostgreSQL veri tabanı ile entegre edilmiştir.

## Başlangıç

Bu doküman, projenin nasıl kurulacağını ve çalıştırılacağını açıklamaktadır.

## Gereksinimler

- Java 11+
- Maven 3.6+
- PostgreSQL 10+

## Kurulum

1. Projeyi klonlayın:
    ```bash
    git clone https://github.com/kullaniciadi/library-management-system.git
    ```

2. Proje dizinine gidin:
    ```bash
    cd library-management-system
    ```

3. PostgreSQL veritabanınızı oluşturun:
    ```sql
    CREATE DATABASE library;
    ```

4. `src/main/resources/application.properties` dosyasını düzenleyerek PostgreSQL veritabanı bağlantı ayarlarını yapın:
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/library
    spring.datasource.username=postgres
    spring.datasource.password=yourpassword
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    ```

5. Maven bağımlılıklarını yükleyin ve projeyi çalıştırın:
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

## Proje Yapısı

Proje, katmanlı bir mimariye sahiptir:
- **Entity**: Veritabanı tablolarını temsil eder.
- **Repository**: Veritabanı işlemleri için CRUD arayüzlerini içerir.
- **Service**: İş mantığını barındırır.
- **Controller**: HTTP isteklerini yönetir.

## API Endpoints

### Book Endpoints
| HTTP Method | Endpoint              | Description                  |
|-------------|-----------------------|------------------------------|
| GET         | `/api/books`          | Tüm kitapları getirir        |
| GET         | `/api/books/{id}`     | Belirli bir kitabı getirir   |
| POST        | `/api/books`          | Yeni bir kitap oluşturur     |
| DELETE      | `/api/books/{id}`     | Belirli bir kitabı siler     |

### Author Endpoints
| HTTP Method | Endpoint              | Description                  |
|-------------|-----------------------|------------------------------|
| GET         | `/api/authors`        | Tüm yazarları getirir        |
| GET         | `/api/authors/{id}`   | Belirli bir yazarı getirir   |
| POST        | `/api/authors`        | Yeni bir yazar oluşturur     |
| DELETE      | `/api/authors/{id}`   | Belirli bir yazarı siler     |

### Category Endpoints
| HTTP Method | Endpoint              | Description                  |
|-------------|-----------------------|------------------------------|
| GET         | `/api/categories`     | Tüm kategorileri getirir     |
| GET         | `/api/categories/{id}`| Belirli bir kategoriyi getirir|
| POST        | `/api/categories`     | Yeni bir kategori oluşturur  |
| DELETE      | `/api/categories/{id}`| Belirli bir kategoriyi siler |

### Publisher Endpoints
| HTTP Method | Endpoint              | Description                  |
|-------------|-----------------------|------------------------------|
| GET         | `/api/publishers`     | Tüm yayınevlerini getirir    |
| GET         | `/api/publishers/{id}`| Belirli bir yayınevini getirir|
| POST        | `/api/publishers`     | Yeni bir yayınevi oluşturur  |
| DELETE      | `/api/publishers/{id}`| Belirli bir yayınevini siler |

### BookBorrowing Endpoints
| HTTP Method | Endpoint               | Description                  |
|-------------|------------------------|------------------------------|
| GET         | `/api/borrowings`      | Tüm ödünç alma işlemlerini getirir|
| GET         | `/api/borrowings/{id}` | Belirli bir ödünç alma işlemini getirir|
| POST        | `/api/borrowings`      | Yeni bir ödünç alma işlemi oluşturur|
| DELETE      | `/api/borrowings/{id}` | Belirli bir ödünç alma işlemini siler|

## Katkıda Bulunanlar

- İsim Soyisim - [GitHub Profiliniz](https://github.com/kullaniciadi)

## Lisans

Bu proje MIT Lisansı ile lisanslanmıştır. Daha fazla bilgi için LICENSE dosyasına bakın.
