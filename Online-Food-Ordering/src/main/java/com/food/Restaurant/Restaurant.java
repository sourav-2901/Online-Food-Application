package com.food.Restaurant;

import com.food.Model.*;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
    @Id
    private Long id;
    private User owner;
    private String name;
    private String cuisineType;
    private String title;
    private List<String> images;
    private String description;
    private Address address;
    private ContactInformation contactInformation;
    private String openingHours;
    private List<Order> orders;
    private LocalDateTime registrationDate;
    private boolean open;
    private List<Food> foods;



}
