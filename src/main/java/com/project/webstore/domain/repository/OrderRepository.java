package com.project.webstore.domain.repository;

import com.project.webstore.domain.Order;

public interface OrderRepository {
   long saveOrder(Order order);
   
   Order getOrderById(long id);
}
