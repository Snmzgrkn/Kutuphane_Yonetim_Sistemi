package dev.patika.kutuphane.dao;

import dev.patika.kutuphane.entities.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepo extends JpaRepository<Publisher,Integer> {
}
