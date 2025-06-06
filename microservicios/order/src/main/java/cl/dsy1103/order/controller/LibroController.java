package cl.dsy1103.order.controller;

import java.util.List;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.dsy1103.order.services.LibroService;
import cl.dsy1103.order.model.Libro;
import cl.dsy1103.order.model.UFData;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestParam;

@Log4j2
@RestController
@RequestMapping("/api/v1/libros")
public class LibroController {
    @Autowired
    private LibroService libroService;

    @GetMapping("")
    public List<Libro> getLibros() {
        log.info("Calling external API");
        UFData ufData = libroService.externalRestCall("13-05-2025");
        log.info("UFData: " + ufData);
        return libroService.getLibros();
    }

    @PostMapping("")
    public Libro addLibro(@RequestBody Libro libro) {
        return libroService.addLibro(libro);
    }

    @GetMapping("{id}")
    public Libro getLibro(@PathVariable int id) {
        return libroService.getLibroById(id);
    }

    @PutMapping("{id}")
    public Libro putMethodName(@PathVariable int id, @RequestBody Libro libro) {
        return libroService.updateLibro(libro);
    }

    @DeleteMapping("{id}")
    public void deleteLibro(@PathVariable int id) {
        libroService.deleteLibro(id);
    }

    @GetMapping("/isbn/{isbn}")
    public Libro getByIsbn(@PathVariable String isbn) {
        System.out.println("ISBN: " + isbn);
        return libroService.getLibroByIsbn(isbn);
    }

}
