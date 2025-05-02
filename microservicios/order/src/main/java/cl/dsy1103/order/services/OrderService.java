package cl.dsy1103.order.services;

import java.util.List;

import cl.dsy1103.order.repository.OrderRepository;
import jakarta.transaction.Transactional;
import cl.dsy1103.order.model.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getOrders() {
        return orderRepository.findAllOrders();
    }

    public void addOrder(Order order) {
        orderRepository.save(order);
        // return order;
    }

    public Order getOrderById(int id) {
        return orderRepository.findById(id).orElse(null);
    }

    public void updateOrder(int id) {
        Order updatedOrder = orderRepository.findById(id).orElse(null);
        if (updatedOrder == null) {
            // throw new OrderNotFoundException("Order not found with id: " + id);
            return;
        }
        orderRepository.save(updatedOrder);
        // return updatedOrder;
    }

    public void deleteOrder(int id) {
        // Order deletedOrder = orderRepository.getOrderById(id);
        orderRepository.deleteById(id);
        // return deletedOrder;
    }

}
