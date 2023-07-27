package com.geekster.Food_Delivery.repository;

import com.geekster.Food_Delivery.model.Authentication;
import com.geekster.Food_Delivery.model.Costumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthenticationRepo extends JpaRepository <Authentication,Long>{
    Authentication findByCostumer(Costumer costumer);
    Authentication findFirstByAuthenticationToken(String token);
}
