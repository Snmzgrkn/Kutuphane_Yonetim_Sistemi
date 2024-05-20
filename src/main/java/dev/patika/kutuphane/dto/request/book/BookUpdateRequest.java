package dev.patika.kutuphane.dto.request.book;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookUpdateRequest {
    private long id;
    private String name;
    private int year;
    private int stock;
}