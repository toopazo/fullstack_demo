package cl.dsy1103.order.controller;

// import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.dsy1103.order.model.Menu;
import cl.dsy1103.order.services.MenuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping("")
    public ResponseEntity<List<Menu>> readAllMenu() {
        List<Menu> menus = menuService.getMenus();
        if (menus.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(menus);
    }

    @PostMapping("")
    public ResponseEntity<Menu> createMenu(@RequestBody Menu menu) {
        if (menu.getName() == null || menu.getName().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        if (menu.getCreatedAt() == null) {
            menu.setCreatedAt(java.time.LocalDateTime.now());
        }
        Menu savedMenu = menuService.addMenu(menu);

        // return ResponseEntity.ok(savedMenu);
        return new ResponseEntity<>(savedMenu, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Menu> readMenuById(@PathVariable int id) {
        Menu menu = menuService.findMenuById(id);
        if (menu == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(menu);
    }

}
