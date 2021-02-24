package com.genetics.nuka_api.repositiry;

import com.genetics.nuka_api.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

   // Order findByOrderId(Long id);
}
