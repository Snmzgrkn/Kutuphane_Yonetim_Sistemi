package dev.patika.kutuphane.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id",columnDefinition = "serial")
    private int id;

    @NotNull
    @Column(name = "category_name")
    private String name;

    @Column(name = "category_description")
    private String description;

    @ManyToMany(mappedBy = "categories",cascade = CascadeType.REMOVE)
    private List<Book> books;

}