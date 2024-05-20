package dev.patika.kutuphane.dto.request.book;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookSaveRequest {
    @NotEmpty
    private String name;
    private int year;
    private int stock;
}
