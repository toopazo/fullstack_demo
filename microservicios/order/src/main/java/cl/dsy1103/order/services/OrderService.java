package cl.dsy1103.order.services;

import java.util.List;

import cl.dsy1103.order.repository.OrderRepository;
import cl.dsy1103.order.model.OrderModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderModel> getOrders() {
        return orderRepository.getOrders();
    }

    public void addOrder(OrderModel order) {
        orderRepository.addOrder(order);
        // return order;
    }

    public OrderModel getOrderById(int id) {
        return orderRepository.getOrderById(id);
    }

    public void updateOrder(int id, OrderModel updatedOrder) {
        orderRepository.updateOrder(id, updatedOrder);
        // return updatedOrder;
    }

    public void deleteOrder(int id) {
        // Order deletedOrder = orderRepository.getOrderById(id);
        orderRepository.deleteOrder(id);
        // return deletedOrder;
    }

}
