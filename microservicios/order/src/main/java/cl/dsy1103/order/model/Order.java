package cl.dsy1103.order.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "dinner_order")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "menu_id", nullable = false)
    private int menuId;

    @Column(name = "table_id", nullable = false)
    private int tableId;

    @Column(name = "menu_count", nullable = false)
    private int menuCount;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

}

// public class OrderModel implements Serializable {

// // private static final long serialVersionUID = -3760445487636086034L;
// private String name;
// private int id;
// private LocalDateTime createdAt;

// public OrderModel() {
// }

// public OrderModel(String name, int id, LocalDateTime createdAt) {
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
