package com.geekster.Food_Delivery.service;

import com.geekster.Food_Delivery.model.Foods;
import com.geekster.Food_Delivery.repository.IFoodRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {
    @Autowired
    IFoodRepo foodRepo;

    public String addFood(Foods food) {
        foodRepo.save(food);
        return "Food added.....!!";
    }

    public List<Foods> getFood() {
     return foodRepo.findAll();
    }



    public String deleteFood(Long id) {
        foodRepo.deleteById(id);
        return "food deleted....!!";
    }
    @Transactional
    public String updateFoodById(Long id, Double price) {
        foodRepo.updateFoodById(id , price);
        return "Food updated Successfully!!";
    }
}
