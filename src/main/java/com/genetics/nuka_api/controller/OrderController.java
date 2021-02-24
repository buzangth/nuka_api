package com.genetics.nuka_api.controller;

import com.genetics.nuka_api.model.Order;
import com.genetics.nuka_api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping
    public ResponseEntity<?> createNewOrder(@Valid @RequestBody Order order){

        Order order1 = orderService.createOrder(order);
        return new ResponseEntity<Order>(order1, HttpStatus.CREATED);
    }
}
