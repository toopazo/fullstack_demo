package cl.dsy1103.order;

import cl.dsy1103.order.model.Libro;
import cl.dsy1103.order.repository.LibroRepository;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
// import java.util.Random;

// Ver detalles de Profile en Spring Boot en la siguiente URL: https://docs.spring.io/spring-boot/reference/features/profiles.html
// @Profile("dev")
// @Profile("prod")
@Profile("non_standard_profile_so_this_will_not_run")
@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    private LibroRepository libroRepository;

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();
        // Random random = new Random();

        // Generar libros
        for (int i = 0; i < 10; i++) {
            Libro libro = new Libro();
            // libro.setId(i + 1);
            libro.setIsbn(faker.code().isbn13());
            libro.setTitle(faker.book().title());
            libro.setAuthor(faker.book().author());
            libro.setPublisher(faker.book().publisher());
            LocalDate localDate = LocalDate.now();
            libro.setPublication_date(localDate.plusDays(i));

            System.out.println("Libro generado: " + libro);

            // Guardar el libro en la base de datos
            try {
                libroRepository.save(libro);
            } catch (org.springframework.dao.DataIntegrityViolationException e) {
                // Handle the exception
                System.err.println("Data integrity violation occurred: " + e.getMessage());
            }

        }
    }
}
