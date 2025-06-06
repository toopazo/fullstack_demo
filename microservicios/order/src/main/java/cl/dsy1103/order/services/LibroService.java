package cl.dsy1103.order.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import cl.dsy1103.order.repository.LibroRepository;
import lombok.extern.log4j.Log4j2;
import cl.dsy1103.order.model.Libro;
import cl.dsy1103.order.model.UFData;

@Log4j2
@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;

    private final RestClient restClient;

    public LibroService(RestClient.Builder restClientBuilder) {
        String baseUrl = "https://mindicador.cl";
        log.info("Base URL: " + baseUrl);
        this.restClient = restClientBuilder.baseUrl(baseUrl).build();
    }

    public UFData externalRestCall(String date) {
        return this.restClient.get().uri("/api/uf/{name}", date).retrieve().body(UFData.class);
    }

    public List<Libro> getLibros() {
        // return libroRepository.getLibros();
        return libroRepository.findAll();
    }

    public Libro addLibro(Libro libro) {
        // libroRepository.addLibro(libro);
        libroRepository.save(libro);
        return libro;
    }

    public Libro getLibroById(int id) {
        // return libroRepository.getLibroById(id);
        return libroRepository.findById(id).orElse(null);
    }

    public Libro updateLibro(Libro updatedLibro) {
        // return libroRepository.updateLibro(updatedLibro);
        return libroRepository.save(updatedLibro);
    }

    public void deleteLibro(int id) {
        // libroRepository.deleteLibro(id);
        libroRepository.deleteById(id);
    }

    public Libro getLibroByIsbn(String isbn) {
        // for (Libro libro : libroRepository.getLibros()) {
        for (Libro libro : libroRepository.findAll()) {
            System.out.println("libroRepository ISBN: " + isbn);
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }
        return null; // or throw an exception
    }
}
