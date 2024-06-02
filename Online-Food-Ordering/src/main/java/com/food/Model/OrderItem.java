package com.food.Model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
public class OrderItem {
    @Id
    private Long id;
    private Food food;
    private int quantity;
    private Long totalPrice;
    private List<String> ingredients;

}
