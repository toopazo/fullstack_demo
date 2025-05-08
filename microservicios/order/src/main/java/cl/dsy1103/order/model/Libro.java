package cl.dsy1103.order.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// @Data
// @AllArgsConstructor
// @NoArgsConstructor
// public class Libro {

//     private int id;
//     private String isbn;
//     private String title;
//     private String author;
//     private String publisher;
//     private LocalDate publicationDate;

// }

@Entity
@Table(name = "libro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "isbn", length = 255, unique = true, nullable = false)
    private String isbn;

    @Column(name = "title", length = 255, unique = true, nullable = false)
    private String title;

    @Column(name = "author", length = 255, unique = true, nullable = false)
    private String author;

    @Column(name = "publisher", length = 255, unique = true, nullable = false)
    private String publisher;

    // @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "publication_date", nullable = false)
    private LocalDate publication_date;

}
