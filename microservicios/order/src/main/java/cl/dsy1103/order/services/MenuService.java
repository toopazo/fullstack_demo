package cl.dsy1103.order.services;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.dsy1103.order.model.Menu;
import cl.dsy1103.order.repository.MenuRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class MenuService {
    @Autowired
    private MenuRepository menuRepository;

    public List<Menu> getMenus() {
        Menu m0 = new Menu();
        List<Menu> lm0 = new ArrayList<Menu>();
        m0.setId(100);
        m0.setName("Menu 100");
        m0.setCreatedAt(java.time.LocalDateTime.now());
        System.out.println(m0.getCreatedAt().toString());
        lm0.add(m0);
        System.out.println("lm0");
        System.out.println(lm0.toString());

        List<Menu> lm1 = menuRepository.findAll();
        System.out.println("lm1");
        System.out.println(lm1.toString());

        List<Menu> lm2 = menuRepository.findAllMenus();
        System.out.println("lm2");
        System.out.println(lm2.toString());

        return lm1;

        // return menuRepository.findAll();
    }

    public Menu findMenuById(int id) {
        return menuRepository.findById(id).orElse(null);
    }

    public Menu addMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    public Menu updateMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    public void deleteMenu(int id) {
        menuRepository.deleteById(id);
    }
}