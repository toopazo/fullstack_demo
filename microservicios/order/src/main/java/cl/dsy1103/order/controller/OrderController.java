package cl.dsy1103.order.controller;

import java.util.List;
import java.time.LocalDateTime;

import cl.dsy1103.order.model.OrderModel;
import cl.dsy1103.order.services.OrderService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	private int counter = 0;

	@GetMapping("")
	public List<OrderModel> getOrders() {
		return orderService.getOrders();
	}

	// Create POST
	@PostMapping("")
	public OrderModel postOrder(@RequestBody OrderModel order) {
		// int id = orderService.getOrders().size() + 1;
		int id = ++counter;
		order.setId(id);
		order.setCreatedAt(LocalDateTime.now());
		orderService.addOrder(order);
		return order;
	}

	// Read GET
	@GetMapping("{id}")
	public OrderModel getOrderById(@PathVariable int id) {
		OrderModel order = orderService.getOrderById(id);
		return order;
	}

	// Update PUT
	@PutMapping("{id}")
	public OrderModel putOrderById(@PathVariable int id, @RequestBody OrderModel order) {
		orderService.updateOrder(id, order);
		return order;
	}

	// Delete DELETE
	@DeleteMapping("{id}")
	public OrderModel deleteOrderById(@PathVariable int id) {
		OrderModel order = orderService.getOrderById(id);
		orderService.deleteOrder(id);
		return order;
	}

}
