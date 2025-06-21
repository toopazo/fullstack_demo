package cl.dsy1103.order.assemblers;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import cl.dsy1103.order.controller.OrderControllerV2;
import cl.dsy1103.order.model.Order;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class OrderModelAssembler implements RepresentationModelAssembler<Order, EntityModel<Order>> {
    @Override
    public EntityModel<Order> toModel(Order order) {
        return EntityModel.of(order,
                linkTo(methodOn(OrderControllerV2.class).getOrderById(order.getId())).withSelfRel(),
                linkTo(methodOn(OrderControllerV2.class).getAllOrders()).withRel("carreras"));
    }
}