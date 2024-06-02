package com.food.Model;

import com.food.Restaurant.Restaurant;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
public class Food {
    @Id
    private Long id;
    private String name;
    private String description;
    private Long price;
    private Category foodCategory;
    private List<String> images;
    private boolean available;
    private Restaurant restaurant;
    private boolean isVegetarian;
    private boolean isSeasonal;
    private List<IngredientsItem> ingredients =new ArrayList<>();
    private Date creationDate;





}
