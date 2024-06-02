package com.food.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.food.Restaurant.Restaurant;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Random;

@Data
@Getter
@Setter
@AllArgsConstructor
@Document(collection = "User")
public class User {
    private static long lastId = 0;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id = 0;
    private String name;
    private String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private List<Order> orders;
    private List<Restaurant> favourites;
    private List<Address> addresses;
    private UserRole role=UserRole.ROLE_CUSTOMER;

    public User() {
        // Increment the lastId and assign it to the current object's id
        Random random=new Random();
        this.id =random.nextLong() ;
    }

    // Constructor with fields (if needed)
    public User(String email, String password,UserRole role /* other fields */) {
        this.id = ++lastId;
        this.email = email;
        this.password = password;
        this.role=role;
        // set other fields
    }

    // Getters and setters
    // It's important not to set the 'id' field manually to maintain uniqueness

    // Optionally, you might want a method to reset the lastId (for testing or other purposes)
    public static void resetLastId() {
        lastId = 0;
    }

}
