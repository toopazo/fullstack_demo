package cl.dsy1103.order.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import cl.dsy1103.order.model.Libro;

@Repository
public class LibroRepositoryOld {
    private List<Libro> libros = new ArrayList<>();

    public List<Libro> getLibros() {
        return libros;
    }

    public void addLibro(Libro libro) {
        libros.add(libro);
    }

    public Libro getLibroById(int id) {
        for (Libro libro : libros) {
            if (libro.getId() == id) {
                return libro;
            }
        }
        return null; // or throw an exception
    }

    public Libro updateLibro(Libro updatedLibro) {
        int id = updatedLibro.getId();
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getId() == id) {
                libros.set(i, updatedLibro);
                return updatedLibro;
            }
        }
        return null; // or throw an exception
    }

    public void deleteLibro(int id) {
        libros.removeIf(libro -> libro.getId() == id);
    }
}
