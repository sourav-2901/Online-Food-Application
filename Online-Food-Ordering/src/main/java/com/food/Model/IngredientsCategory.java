package com.food.Model;

import com.food.Restaurant.Restaurant;
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
public class IngredientsCategory {
    @Id
    private Long id;
    private String name;
    private Restaurant restaurant;
    private List<IngredientsItem> ingredientItem;

}
