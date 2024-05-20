package dev.patika.kutuphane.dao;

import dev.patika.kutuphane.entities.BookBorrowing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookBorrowingRepo extends JpaRepository<BookBorrowing,Integer> {
}
