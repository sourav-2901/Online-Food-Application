package com.food.Request;

import com.food.Model.Address;
import com.food.Model.ContactInformation;
import lombok.*;

import java.util.List;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateRestaurantReq {
    private Long id;
    private String name;
    private String description;
    private String cusineType;
    private Address address;
    private ContactInformation contactInformation;
    private String openingHours;
    private List<String> images;


}
