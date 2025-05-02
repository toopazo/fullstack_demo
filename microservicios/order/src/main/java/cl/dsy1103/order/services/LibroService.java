package cl.dsy1103.order.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cl.dsy1103.order.repository.LibroRepository;
import cl.dsy1103.order.model.Libro;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;

    public List<Libro> getLibros() {
        return libroRepository.getLibros();
    }

    public Libro addLibro(Libro libro) {
        libroRepository.addLibro(libro);
        return libro;
    }

    public Libro getLibroById(int id) {
        return libroRepository.getLibroById(id);
    }

    public Libro updateLibro(Libro updatedLibro) {
        return libroRepository.updateLibro(updatedLibro);
    }

    public void deleteLibro(int id) {
        libroRepository.deleteLibro(id);
    }

    public Libro getLibroByIsbn(String isbn) {
        for (Libro libro : libroRepository.getLibros()) {
            System.out.println("libroRepository ISBN: " + isbn);
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }
        return null; // or throw an exception
    }
}
