package dev.patika.kutuphane.dto.response.bookborrowing;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookBorrowingResponse {
    private String name;
    private LocalDate date;
    private String mail;
}