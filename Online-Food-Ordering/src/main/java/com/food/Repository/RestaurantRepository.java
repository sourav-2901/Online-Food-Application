package com.food.Repository;

import com.food.Model.User;
import com.food.Restaurant.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RestaurantRepository extends MongoRepository<Restaurant, Long> {

    @Query("{$or:[{'name': {$regex: ?0, $options: 'i'}}, {'description': {$regex: ?0, $options: 'i'}}, {'cusineType': {$regex: ?0, $options: 'i'}}, {'address.street': {$regex: ?0, $options: 'i'}}, {'contactInformation.phoneNumber': {$regex: ?0, $options: 'i'}}, {'openingHours': {$regex: ?0, $options: 'i'}}]}")
    List<Restaurant> findBySearchQuery(String query);

    Restaurant findByOwnerId(Long id);


}
