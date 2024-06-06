package com.food.Restaurant;

import com.food.Model.*;
import jakarta.persistence.Id;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Restaurant")
public class Restaurant {
    @Id
    private ObjectId id;
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
