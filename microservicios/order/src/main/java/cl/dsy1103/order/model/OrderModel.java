package cl.dsy1103.order.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderModel implements Serializable {

    // private static final long serialVersionUID = -3760445487636086034L;
    private String name;
    private int id;
    private LocalDateTime createdAt;

}

// public class Order implements Serializable {

// // private static final long serialVersionUID = -3760445487636086034L;
// private String name;
// private int id;
// private LocalDateTime createdAt;

// public Order() {
// }

// public Order(String name, int id, LocalDateTime createdAt) {
// this.name = name;
// this.id = id;
// this.createdAt = createdAt;
// }

// public String getName() {
// return this.name;
// }

// public void setName(String name) {
// this.name = name;
// }

// public int getId() {
// return this.id;
// }

// public void setId(int id) {
// this.id = id;
// }

// public LocalDateTime getCreatedAt() {
// return this.createdAt;
// }

// public void setCreatedAt(LocalDateTime createdAt) {
// this.createdAt = createdAt;
// }

// //   additional getters/setters

// }