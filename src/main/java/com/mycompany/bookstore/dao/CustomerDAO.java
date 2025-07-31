/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bookstore.dao;

/**
 *
 * @author Nk
 */

import com.mycompany.bookstore.model.Customers;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CustomerDAO {
    private static final List<Customers> customers = new ArrayList<>();
    private static final AtomicInteger customerId = new AtomicInteger(0);
    
    public List<Customers> getAllCustomer(){
        return customers;
    }
    
    public Customers getCustomerById(int id){
        for(Customers customer:customers){
            if(customer.getId() == id){
                return customer;
            }
        }
        return null;
    }
    
    public void addCustomer(Customers customer){
        int id = customerId.incrementAndGet();
        customer.setId(id);
        customers.add(customer);
    }
    
    public boolean updateCustomer(Customers customer){
        for(Customers customer1:customers){
            if(customer1.getId() == customer.getId()){
                customer1.setEmail(customer.getEmail());
                customer1.setName(customer.getName());
                customer1.setPassword(customer.getPassword());
                return true;
            }
        }
        return false;
    }
    
    public boolean deleteCustomerById(int id){
        return customers.removeIf(customer1 -> customer1.getId() == id);
    }
    
}
