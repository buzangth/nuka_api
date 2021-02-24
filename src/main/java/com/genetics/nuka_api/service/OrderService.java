package com.genetics.nuka_api.service;

import com.genetics.nuka_api.model.Order;

import com.genetics.nuka_api.repositiry.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderService {


    @Autowired
    OrderRepository orderRepository;

    public Order createOrder(Order order){

        order.setDate(new Date());
        return orderRepository.save(order);
    }
}
