package dev.patika.kutuphane.dto.request.author;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorSaveRequest {
    @NotEmpty
    private String name;
    private int birthYear;
    private String country;
}
