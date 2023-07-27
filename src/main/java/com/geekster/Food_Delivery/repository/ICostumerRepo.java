package com.geekster.Food_Delivery.repository;

import com.geekster.Food_Delivery.model.Costumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICostumerRepo extends JpaRepository<Costumer,Long> {
    Costumer findFirstByCostumerEmailId(String userEmailId);
}
