package cl.dsy1103.order.controller;

import java.util.List;
import java.time.LocalDateTime;

import cl.dsy1103.order.model.Order;
import cl.dsy1103.order.services.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/v1/order")
@Tag(name = "Order API", description = "API para manejar ordenes en un restaurante. La base de datos es manipulada usando operaciones CRUD.")
public class OrderController {

	@Autowired
	private OrderService orderService;
	private int counter = 0;

	@GetMapping("")
	@Operation(summary = "Obtener todas las ordenes", description = "Retorna una lista de todas las ordenes en el sistema.")
	@ApiResponse(responseCode = "200", description = "Operación exitosa")
	public ResponseEntity<List<Order>> getOrders() {
		List<Order> orders = orderService.getOrders();
		return new ResponseEntity<>(orders, HttpStatus.OK);
	}

	// Create POST
	@PostMapping("")
	public ResponseEntity<Order> postOrder(@RequestBody Order order) {
		// int id = orderService.getOrders().size() + 1;
		int id = ++counter;
		order.setId(id);
		order.setCreatedAt(LocalDateTime.now());
		orderService.addOrder(order);
		// return order;

		// Build the URI for the new resource
		// URI location = ServletUriComponentsBuilder.fromCurrentRequest()
		// .path("/{id}")
		// .buildAndExpand(savedMenuId)
		// .toUri();
		// return ResponseEntity.created(location).body(savedMenu);

		return new ResponseEntity<>(order, HttpStatus.CREATED);
	}

	// Read GET
	@GetMapping("{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable("id") int id) {
		Order order = orderService.getOrderById(id);
		return ResponseEntity.ok(order);
	}

	// Update PUT
	@PutMapping("{id}")
	public void putOrderById(@PathVariable("id") int id) {
		orderService.updateOrder(id);
		return;
	}

	// Delete DELETE
	@DeleteMapping("{id}")
	public Order deleteOrderById(@PathVariable("id") int id) {
		Order order = orderService.getOrderById(id);
		orderService.deleteOrder(id);
		return order;
	}

}
