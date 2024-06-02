package com.food.Repository;

import com.food.Model.Cart;
import com.food.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CartRepository extends MongoRepository<Cart, Long> {
}
