package cl.dsy1103.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}

	// @GetMapping("/api/v1/hello")
	// public String hello(@RequestParam(value = "name", defaultValue = "World")
	// String name) {
	// return String.format("Hello %s!", name);
	// }

	// @GetMapping("/api/v1/suma")
	// public long suma(@RequestParam(name = "a", required = true) long a,
	// @RequestParam(name = "b", required = true) long b) {
	// return a + b;
	// }

	// @GetMapping("/api/v1/multi")
	// public long multi(@RequestParam(name = "a", required = true) long a,
	// @RequestParam(name = "b", required = true) long b) {
	// return a * b;
	// }

}
