package dev.patika.kutuphane.business.abstracts;

import dev.patika.kutuphane.entities.Author;
import dev.patika.kutuphane.entities.Book;
import org.springframework.data.domain.Page;

public interface IAuthorService {
    Author save(Author author);
    Author get(int id);
    Page<Author> cursor(int page, int pageSize);

    Author update(Author author);

    boolean delete(int id);
}
