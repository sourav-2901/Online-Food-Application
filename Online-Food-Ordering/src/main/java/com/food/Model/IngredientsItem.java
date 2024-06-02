package com.food.Model;

import com.food.Restaurant.Restaurant;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class IngredientsItem {
    @Id
    private Long Id;
    private IngredientsCategory category;
    private Restaurant restaurant;
    private boolean inStock;

}
