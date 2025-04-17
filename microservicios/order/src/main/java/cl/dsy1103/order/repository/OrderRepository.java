package cl.dsy1103.order.repository;

import cl.dsy1103.order.model.OrderModel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;

@Repository
public class OrderRepository {
    private List<OrderModel> orders = new ArrayList<>();

    public List<OrderModel> getOrders() {
        return orders;
    }

    public void addOrder(OrderModel order) {
        orders.add(order);
    }

    public OrderModel getOrderById(int id) {
        for (OrderModel order : orders) {
            if (order.getId() == id) {
                return order;
            }
        }
        return null; // or throw an exception
    }

    public void updateOrder(int id, OrderModel updatedOrder) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getId() == id) {
                orders.set(i, updatedOrder);
                return;
            }
        }
        // throw an exception if order not found
    }

    public void deleteOrder(int id) {
        orders.removeIf(order -> order.getId() == id);
    }
}
