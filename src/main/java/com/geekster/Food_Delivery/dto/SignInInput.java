package com.geekster.Food_Delivery.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SignInInput {
    private String userEmailId;
    private String password;
}
