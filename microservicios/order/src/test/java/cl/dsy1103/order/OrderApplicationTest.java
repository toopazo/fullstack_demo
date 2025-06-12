package cl.dsy1103.order;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import cl.dsy1103.order.controller.LibroController;

// @SpringBootTest
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OrderApplicationTest {
    @Autowired
    private LibroController libroController;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @Order(1)
    void contextLoads() {
        System.out.println("Testing the context loading...");
        // System.out.println("Server running on port: " + port);
    }

    @Test
    @Order(2)
    void contextLoads2() throws Exception {
        System.out.println("Testing the context loading. and the controller...");
        assertThat(libroController).isNotNull();
    }

    @Test
    @Order(3)
    void getLibrosContainsBrackets() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port +
                "/api/v1/libros",
                String.class)).toString().contains("[");
    }

    // @Test
    // void shouldReturnDefaultMessage() throws Exception {
    // this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
    // .andExpect(content().string(containsString("Hello, World")));
    // }
}