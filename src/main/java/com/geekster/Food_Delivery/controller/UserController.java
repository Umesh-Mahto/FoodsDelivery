package com.geekster.Food_Delivery.controller;

import com.geekster.Food_Delivery.dto.SignInInput;
import com.geekster.Food_Delivery.dto.SignInOutput;
import com.geekster.Food_Delivery.dto.SignUpInput;
import com.geekster.Food_Delivery.dto.SignUpOutput;
import com.geekster.Food_Delivery.service.CostumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    CostumerService costumerService;

    @PostMapping("/signUp")
    public SignUpOutput signup(@RequestBody SignUpInput signUpInputData) {
        return costumerService.signUp(signUpInputData);
    }
    @PostMapping("/signIn")
    public SignInOutput signIn(@RequestBody SignInInput signInInputData){
        return costumerService.signIn(signInInputData);
    }
}
