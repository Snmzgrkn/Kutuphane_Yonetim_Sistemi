package dev.patika.kutuphane.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id",columnDefinition = "serial")
    private int id;

    @Column(name = "book_name",nullable = false)
    private String name;

    @Column(name = "book_year",nullable = false)
    private int year;

    @Column(name = "book_stock",nullable = false)
    private int stock;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    @JoinTable(name = "book_category",joinColumns = {@JoinColumn(name = "book_category_book_id")},inverseJoinColumns = {@JoinColumn(name = "book_category_category_id")})
    private List<Category> categories;

}