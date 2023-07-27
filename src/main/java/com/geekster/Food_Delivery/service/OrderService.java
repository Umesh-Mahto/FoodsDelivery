package com.geekster.Food_Delivery.service;

import com.geekster.Food_Delivery.model.Foods;
import com.geekster.Food_Delivery.model.OrderFood;
import com.geekster.Food_Delivery.model.Restaurant;
import com.geekster.Food_Delivery.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    IOrderRepo orderRepo;
    @Autowired
    IFoodRepo foodRepo;
    @Autowired
    IRestaurantRepo restaurantRepo;
    @Autowired
    IAuthenticationRepo authenticationRepo;
    @Autowired
    ICostumerRepo costumerRepo;


    public Iterable<OrderFood> getAllOrderFood() {
       return orderRepo.findAll();
    }

    public boolean check(String emailId, String token) {
            if(emailId == null || token == null){
                throw new IllegalStateException("Wrong EmailId And Password!!");
            }
            try {
                String costumerEmail = costumerRepo.findFirstByCostumerEmailId(emailId).getCostumerEmailId();
                String authenticationToken = authenticationRepo.findFirstByAuthenticationToken(token).getAuthenticationToken();

                return costumerEmail.equals(emailId) && authenticationToken.equals((token));
            }catch (Exception e){
                throw new IllegalStateException("Wrong EmailId Or Password!!");
            }

        }

    public String addOrder(OrderFood orderFood) {
        Long foodId = orderFood.getFoods().getFoodsID();
        Long restaurantId = orderFood.getRestaurant().getRestaurantID();
        Foods foodsObj = foodRepo.findById(foodId).get();
        Restaurant restuarentObj = restaurantRepo.findById(restaurantId).get();

        orderFood.setFoods(foodsObj);
        orderFood.setRestaurant(restuarentObj);

        orderRepo.save(orderFood);

        return "Ordered Successfully!!";
    }
}

