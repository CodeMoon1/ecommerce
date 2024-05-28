package com.souza.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.souza.projeto.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long>{
}
