package com.food.Service;

import com.food.Model.RestaurantDto;
import com.food.Model.User;
import com.food.Request.CreateRestaurantReq;
import com.food.Restaurant.Restaurant;

import java.util.List;

public interface RestaurantService {
    public Restaurant createRestaurant(CreateRestaurantReq restaurantReq, User user);
    public Restaurant updateRestaurant(Long restaurantId,CreateRestaurantReq updatedReq) throws Exception;
    public void deleteRestaurant(Long restaurantId) throws Exception;
    public List<Restaurant> getAllRestaurant();
    public List<Restaurant> searchRestaurant(String query);
    public Restaurant findRestaurantById(Long id)  throws Exception;
    public Restaurant findRestaurantByUserId(Long UserId) throws Exception;
    public Restaurant addToFavorites(Long restaurantId, User user) throws Exception;
    public Restaurant updateRestaurantStatus(Long id)throws Exception;

}
