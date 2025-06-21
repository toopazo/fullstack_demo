package cl.dsy1103.order.controller;

import java.util.stream.Collectors;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.MediaTypes;

import cl.dsy1103.order.model.Order;
import cl.dsy1103.order.services.OrderService;
import cl.dsy1103.order.assemblers.OrderModelAssembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/v2/order")
public class OrderControllerV2 {
    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderModelAssembler assembler;

    @GetMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public CollectionModel<EntityModel<Order>> getAllOrders() {
        List<EntityModel<Order>> orders = orderService.getOrders().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(orders,
                linkTo(methodOn(OrderControllerV2.class).getAllOrders()).withSelfRel());
    }

    @GetMapping(value = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public EntityModel<Order> getOrderById(@PathVariable int id) {
        Order order = orderService.getOrderById(id);
        return assembler.toModel(order);
    }

    @PostMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<EntityModel<Order>> createOrder(@RequestBody Order order) {
        // Order newOrder = orderService.addOrder(order);
        orderService.addOrder(order);
        Order newOrder = order;
        return ResponseEntity
                .created(linkTo(methodOn(OrderControllerV2.class).getOrderById(newOrder.getId())).toUri())
                .body(assembler.toModel(newOrder));
    }

    // @PutMapping(value = "/{codigo}", produces = MediaTypes.HAL_JSON_VALUE)
    // public ResponseEntity<EntityModel<Order>> updateOrder(@PathVariable String
    // codigo, @RequestBody Order order) {
    // order.setCodigo(codigo);
    // Order updatedOrder = orderService.save(order);
    // return ResponseEntity
    // .ok(assembler.toModel(updatedOrder));
    // }

    @DeleteMapping(value = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<?> deleteOrder(@PathVariable int id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}
