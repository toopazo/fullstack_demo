package cl.dsy1103.order.repository;

import java.time.LocalDateTime;
import java.util.List;

import cl.dsy1103.order.model.Menu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {

    // List<Menu> findAll(); // This method is inherited from JpaRepository

    List<Menu> findByName(String name); // This method is inherited from JpaRepository

    List<Menu> findByCreatedAt(LocalDateTime createdAt); // This method is inherited from JpaRepository

    @Query("SELECT m FROM Menu m WHERE m.name LIKE '%:pattern%'")
    List<Menu> findByNameLike(String pattern); // Custom query to find menus by name pattern

    @Query(value = "select * from menu", nativeQuery = true)
    List<Menu> findAllMenus(); // Custom query to find all menus
}
