package com.food.Repository;

import com.food.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User findByName(String name);
    User findByEmail(String email);
}
