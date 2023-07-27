package com.geekster.Food_Delivery.controller;

import com.geekster.Food_Delivery.model.Foods;
import com.geekster.Food_Delivery.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodController {
    @Autowired
    FoodService foodService;

    @PostMapping("/addFood")
    public String addFood(@RequestBody Foods food){
        return foodService.addFood(food);
    }

    @GetMapping("/getFood")
    public List<Foods> getFood(){
        return foodService.getFood();
    }

    @PutMapping("updateFood/{id}/{price}")
    public String updateFood(@PathVariable Long id , @PathVariable Double price){
        return foodService.updateFoodById(id , price);
    }

    @DeleteMapping("/deleteFood/{id}")
    public String deleteFood(@PathVariable Long id) {
        return foodService.deleteFood(id);
    }
}
