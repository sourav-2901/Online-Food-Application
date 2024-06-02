package com.food.ServiceImpl;

import com.food.Model.Address;
import com.food.Model.RestaurantDto;
import com.food.Model.User;
import com.food.Repository.AddressRepository;
import com.food.Repository.RestaurantRepository;
import com.food.Repository.UserRepository;
import com.food.Request.CreateRestaurantReq;
import com.food.Restaurant.Restaurant;
import com.food.Service.RestaurantService;
import com.food.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Restaurant createRestaurant(CreateRestaurantReq restaurantReq, User user) {
        Address address=addressRepository.save(restaurantReq.getAddress());
        Restaurant restaurant=new Restaurant();
        restaurant.setAddress(address);
        restaurant.setContactInformation(restaurantReq.getContactInformation());
        restaurant.setCuisineType(restaurantReq.getCusineType());
        restaurant.setDescription(restaurantReq.getDescription());
        restaurant.setImages(restaurantReq.getImages());
        restaurant.setName(restaurantReq.getName());
        restaurant.setOpeningHours(restaurantReq.getOpeningHours());
        restaurant.setRegistrationDate(LocalDateTime.now());
        restaurant.setOwner(user);
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant updateRestaurant(Long restaurantId, CreateRestaurantReq updatedReq) throws Exception {
        Restaurant restaurant=findRestaurantById(restaurantId);
        if(null!=restaurant.getCuisineType()){
            restaurant.setCuisineType(updatedReq.getCusineType());
        }
        if(null!=restaurant.getDescription()){
            restaurant.setDescription(updatedReq.getDescription());
        }
        if(null!=restaurant.getName()){
            restaurant.setName(updatedReq.getName());
        }
        return restaurantRepository.save(restaurant);
    }

    @Override
    public void deleteRestaurant(Long restaurantId) throws Exception {
        Restaurant restaurant=findRestaurantById(restaurantId);
        restaurantRepository.delete(restaurant);
    }

    @Override
    public List<Restaurant> getAllRestaurant() {
        return restaurantRepository.findAll();
    }

    @Override
    public List<Restaurant> searchRestaurant(String query) {
        return restaurantRepository.findBySearchQuery(query);
    }

    @Override
    public Restaurant findRestaurantById(Long id) throws Exception {
        Optional<Restaurant> restaurant=restaurantRepository.findById(id);
        if(restaurant.isEmpty()){
            throw new Exception("No matching restaurant with given ID ");
        }
        return restaurant.get();
    }

    @Override
    public Restaurant findRestaurantByUserId(Long UserId) throws Exception {
        Restaurant restaurant=restaurantRepository.findByOwnerId(UserId);
        if(null==restaurant){
            throw new Exception("No restaurant found given user ID");
        }
        return restaurant;
    }

    @Override
    public Restaurant addToFavorites(Long restaurantId, User user) throws Exception {
        Optional<Restaurant> restaurant=restaurantRepository.findById(restaurantId);
        Restaurant restaurantDto=new Restaurant();
        if(null!=restaurant.get()) {
            restaurantDto.setDescription(restaurant.get().getDescription());
            restaurantDto.setImages(restaurant.get().getImages());
            restaurantDto.setTitle(restaurant.get().getTitle());
            restaurantDto.setId(restaurant.get().getId());
        }
        if(user.getFavourites().contains(restaurantDto)){
            user.getFavourites().remove(restaurantDto);
        }else {
            user.getFavourites().add(restaurantDto);
        }
        userRepository.save(user);
        return restaurantDto;
    }

    @Override
    public Restaurant updateRestaurantStatus(Long id) throws Exception {
        Optional<Restaurant> restaurant=restaurantRepository.findById(id);
        if(null!=restaurant){
            restaurant.get().setOpen(!restaurant.get().isOpen());
        }
        return restaurantRepository.save(restaurant.get());
    }
}
