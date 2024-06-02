package com.food.Model;

import com.food.Restaurant.Restaurant;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
public class Order {
    @Id
    private long id;
    private String customer;
    private Restaurant restaurant;
    private Long totalAmount;
    private String orderStatus;
    private Date createdAt;
    private Address deliveryAddress;
    private List<OrderItem> items;
    private Payment payment;
    private String totalItem;
    private String totalPrice;

}
