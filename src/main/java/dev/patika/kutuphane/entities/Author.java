package dev.patika.kutuphane.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id",columnDefinition = "serial")
    private int id;

    @Column(name = "author_name",nullable = false)
    private String name;
    @Column(name = "author_birthYear")
    private int birthYear;
    @Column(name = "author_country")
    private String country;
}
