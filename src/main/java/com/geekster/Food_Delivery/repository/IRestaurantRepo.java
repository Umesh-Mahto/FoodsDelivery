package com.geekster.Food_Delivery.repository;

import com.geekster.Food_Delivery.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRestaurantRepo extends JpaRepository<Restaurant,Long> {
}
