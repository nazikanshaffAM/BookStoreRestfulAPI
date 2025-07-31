/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bookstore.dao;

/**
 *
 * @author Nk
 */

import com.mycompany.bookstore.model.Carts;
import com.mycompany.bookstore.model.Orders;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
 

public class OrderDAO {
     private static final List<Orders> orders = new ArrayList<>();
    private static final AtomicInteger orderId = new AtomicInteger(0);
    
    public List<Orders> getOrderByCustomerId(int customerId){
        return orders.stream().filter(order -> order.getCustomerId() == customerId).collect(Collectors.toList());
    }
    
    public Orders getOrderByCustomerIdAndOrderId(int customerId, int orderId){
        return orders.stream().filter(order -> order.getCustomerId() == customerId && order.getId() == orderId).findFirst().orElse(null);
    }
    
    public Orders createOrder(int customerId, List<Carts> carts){
        int newOrderId = orderId.incrementAndGet();
        Orders newOrder = new Orders(newOrderId,customerId,new ArrayList<>(carts),new Date());
        orders.add(newOrder);
        return newOrder;
    }
    
}
