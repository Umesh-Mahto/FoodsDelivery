package com.geekster.Food_Delivery.service;

import com.geekster.Food_Delivery.model.Foods;
import com.geekster.Food_Delivery.model.Restaurant;
import com.geekster.Food_Delivery.repository.IFoodRepo;
import com.geekster.Food_Delivery.repository.IRestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
    @Autowired
    IRestaurantRepo restaurantRepo;

    @Autowired
    IFoodRepo foodRepo;

    public String addRestaurant(Restaurant restaurant) {
        List<Foods> foodList =restaurant.getFoods();
        for(Foods foodObj : foodList){
            foodObj.setRestaurant(restaurant);
        }
        restaurantRepo.save(restaurant);
        return "Restaurant added Successfully!!";
    }

    public Iterable<Restaurant> getAllRestaurant() {
        return restaurantRepo.findAll();
    }
}
