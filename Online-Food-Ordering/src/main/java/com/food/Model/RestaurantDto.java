package com.food.Model;

import jakarta.persistence.Id;
import lombok.*;

import java.util.List;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDto {
    private String description;
    private List<String> images;
    private String title;
    @Id
    private long id;


}
