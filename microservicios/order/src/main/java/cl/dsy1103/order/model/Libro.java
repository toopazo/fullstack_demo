package cl.dsy1103.order.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Libro {

    private int id;
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private LocalDate publicationDate;

}
