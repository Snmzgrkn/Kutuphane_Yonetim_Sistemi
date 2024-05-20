package dev.patika.kutuphane.business.abstracts;

import dev.patika.kutuphane.entities.Book;
import dev.patika.kutuphane.entities.Category;
import org.springframework.data.domain.Page;

public interface IBookService {
    Book save(Book book);
    Book get(int id);
    Page<Book> cursor(int page, int pageSize);

    Book update(Book book);

    boolean delete(int id);
}
