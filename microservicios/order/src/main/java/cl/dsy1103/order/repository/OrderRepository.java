package cl.dsy1103.order.repository;

import cl.dsy1103.order.model.Order;

import java.util.List;
import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    // List<Order> findAll(); // This method is inherited from JpaRepository

    List<Order> findByCreatedAt(LocalDateTime createdAt); // This method is inherited from JpaRepository

    // @Query("SELECT m FROM dinner_order m WHERE m.menu_id = 'id'")
    // List<Order> findByMenuId(int id); // Custom query to find menus by name
    // pattern

    @Query(value = "select * from  dinner_order", nativeQuery = true)
    List<Order> findAllOrders(); // Custom query to find all menus
}

// @Repository
// public class OrderRepository {
// private List<Order> orders = new ArrayList<>();

// public List<Order> getOrders() {
// return orders;
// }

// public void addOrder(Order order) {
// orders.add(order);
// }

// public Order getOrderById(int id) {
// for (Order order : orders) {
// if (order.getId() == id) {
// return order;
// }
// }
// return null; // or throw an exception
// }

// public void updateOrder(int id, Order updatedOrder) {
// for (int i = 0; i < orders.size(); i++) {
// if (orders.get(i).getId() == id) {
// orders.set(i, updatedOrder);
// return;
// }
// }
// // throw an exception if order not found
// }

// public void deleteOrder(int id) {
// orders.removeIf(order -> order.getId() == id);
// }

// public int getNumberOfOrders() {
// return orders.size();
// }
// }
