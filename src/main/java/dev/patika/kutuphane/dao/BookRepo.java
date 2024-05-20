package dev.patika.kutuphane.dao;

import dev.patika.kutuphane.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book,Integer> {
}
