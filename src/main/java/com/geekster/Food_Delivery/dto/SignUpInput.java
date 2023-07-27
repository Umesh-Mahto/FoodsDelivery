package com.geekster.Food_Delivery.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpInput {
    private String userEmailId;
    private String userPassword;
    private  String userFirstName;
    private String userLastName;
    private String userAddress;
    private  String userContact;
}
