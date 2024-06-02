package com.food.Model;

import jakarta.persistence.Id;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    @Id
    private Long Id;
    private User customer;
    private Long total;
    private List<CartItem> cartItem;

}
