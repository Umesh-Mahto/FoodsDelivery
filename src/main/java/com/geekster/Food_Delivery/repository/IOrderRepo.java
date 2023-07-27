package com.geekster.Food_Delivery.repository;

import com.geekster.Food_Delivery.model.OrderFood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepo extends JpaRepository<OrderFood,Long> {
}
