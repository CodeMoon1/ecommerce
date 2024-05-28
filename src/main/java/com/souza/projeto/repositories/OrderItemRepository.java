package com.souza.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.souza.projeto.entities.OrderItem;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem,Long>{

}
