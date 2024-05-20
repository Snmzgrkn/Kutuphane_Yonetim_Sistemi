package dev.patika.kutuphane.dao;

import dev.patika.kutuphane.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author,Integer> {
}
