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
public class CartItem {
    @Id
    private Long id;
    private Cart cart;
    private Food food;
    private int quantity;
    private List<String> ingredients;
    private Long totalPrice;

}
