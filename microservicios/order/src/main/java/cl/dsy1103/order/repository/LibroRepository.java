package cl.dsy1103.order.repository;

import java.time.LocalDateTime;
import java.util.List;

import cl.dsy1103.order.model.Libro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer> {

    // List<Libro> findAll(); // This method is inherited from JpaRepository

    // List<Libro> findByName(String name); // This method is inherited from
    // JpaRepository

    // List<Libro> findByCreatedAt(LocalDateTime createdAt); // This method is
    // inherited from JpaRepository

    // @Query("SELECT m FROM libro m WHERE m.name LIKE '%:pattern%'")
    // List<Libro> findByNameLike(String pattern); // Custom query to find menus by
    // name pattern

    @Query(value = "select * from libro", nativeQuery = true)
    List<Libro> findAllMenus(); // Custom query to find all menus
}
