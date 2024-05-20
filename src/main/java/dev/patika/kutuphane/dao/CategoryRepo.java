package dev.patika.kutuphane.dao;

import dev.patika.kutuphane.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Integer> {
}
