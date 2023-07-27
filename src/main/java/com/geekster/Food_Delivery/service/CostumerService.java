package com.geekster.Food_Delivery.service;

import com.geekster.Food_Delivery.dto.SignInInput;
import com.geekster.Food_Delivery.dto.SignInOutput;
import com.geekster.Food_Delivery.dto.SignUpInput;
import com.geekster.Food_Delivery.dto.SignUpOutput;
import com.geekster.Food_Delivery.model.Authentication;
import com.geekster.Food_Delivery.model.Costumer;
import com.geekster.Food_Delivery.repository.IAuthenticationRepo;
import com.geekster.Food_Delivery.repository.ICostumerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class CostumerService {
    @Autowired
    ICostumerRepo costumerRepo;
    @Autowired
    IAuthenticationRepo authenticationRepo;

    public SignUpOutput signUp(SignUpInput signUpInputData) {
        Costumer costumer =costumerRepo.findFirstByCostumerEmailId(signUpInputData.getUserEmailId());
     if(costumer!=null){
         throw new IllegalStateException("Email AllReady Exists");
     }
     String encryptedPassword;
     try{
         encryptedPassword=encryptPassword(signUpInputData.getUserPassword());
     }
     catch(NoSuchAlgorithmException e){
         throw new RuntimeException(e);
     }
     costumer=new Costumer(signUpInputData.getUserEmailId(),encryptedPassword,signUpInputData.getUserAddress(),signUpInputData.getUserFirstName(),signUpInputData.getUserLastName(),signUpInputData.getUserContact());
        costumerRepo.save(costumer);

        Authentication authentication = new Authentication(costumer);
        authenticationRepo.save(authentication);

        return new SignUpOutput("SignUp Successfully " ,"Now You can SignIn");
    }

    private String encryptPassword(String userPassword) throws NoSuchAlgorithmException {
        MessageDigest md5=MessageDigest.getInstance("md5");
        md5.update(userPassword.getBytes());
        byte[]password=md5.digest();
        String hash=new String(password);
        return hash;
    }

    public SignInOutput signIn(SignInInput signInInputData) {
        Costumer costumer=costumerRepo.findFirstByCostumerEmailId(signInInputData.getUserEmailId());
        if(costumer==null){
            throw new IllegalStateException("email not found");
        }

        String encryptedPassword;
        try{
            encryptedPassword=encryptPassword(signInInputData.getPassword());
        }catch(NoSuchAlgorithmException e){
            throw new RuntimeException();
        }
        if(!encryptedPassword.equals(costumer.getCostumerPassword())){
            throw new IllegalStateException("wrong password");
        }
        Authentication authentication=authenticationRepo.findByCostumer(costumer);
       return new SignInOutput("SignIn Successfully",authentication.getAuthenticationToken());
    }
}
