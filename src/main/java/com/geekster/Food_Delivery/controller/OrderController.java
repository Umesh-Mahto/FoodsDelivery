package com.geekster.Food_Delivery.controller;

import com.geekster.Food_Delivery.model.OrderFood;
import com.geekster.Food_Delivery.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/getAllOrder")
    public Iterable<OrderFood> getAllOrder(){

        return orderService.getAllOrderFood();
    }
}
