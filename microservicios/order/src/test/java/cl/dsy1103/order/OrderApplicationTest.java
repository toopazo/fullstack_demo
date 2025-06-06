// package cl.dsy1103.order;

// import org.junit.jupiter.api.Test;
// import org.springframework.boot.test.context.SpringBootTest;
// // import static org.assertj.core.api.Assertions.assertThat;
// // import org.springframework.beans.factory.annotation.Autowired;
// // import
// org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
// // import org.springframework.boot.test.web.client.TestRestTemplate;
// // import org.springframework.boot.test.web.server.LocalServerPort;
// // import org.springframework.test.web.servlet.MockMvc;
// // import
// org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
// // import static
// org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// @SpringBootTest
// // @AutoConfigureMockMvc
// public class OrderApplicationTest {

// @Test
// void contextLoads() {
// }

// // @Autowired
// // private MockMvc mockMvc;

// // @Autowired
// // private OrderApplication controller;

// // @LocalServerPort
// // private int port;

// // @Autowired
// // private TestRestTemplate restTemplate;

// // @Test
// // void test1() throws Exception {
// // assertThat(this.restTemplate.getForObject("http://localhost:" + port +
// // "/api/v1/libros",
// // String.class)).contains("[");
// // }

// // @Test
// // void contextLoads() throws Exception {
// // System.out.println("Port: " + port);
// // // assertThat(controller).isNotNull();
// // }

// // @Test
// // public void test0() throws Exception {
// // // mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/libros"))
// // // .andDo(result -> {
// // // String content = result.getResponse().getContentAsString();
// // // System.out.println("Response content: " + content);
// // // assertThat(content).contains("[");
// // // });
// //
// mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/libros")).andExpect(status().isOk());
// // }
// }
