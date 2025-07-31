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
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CartDAO {
    private static final List<Carts> carts = new ArrayList<>();
    
    public List<Carts> getCartItemByCustomerId(int customerId){
        return carts.stream().filter(cart -> cart.getCustomerId() == customerId).collect(Collectors.toList());
    }
    
    public Carts addItemToCart(int customerId, Carts cart){
        carts.add(cart);
        return cart;
    }
    
    public Carts updateCartItem(int customerId, int bookId, Carts updatedCart){
        for(Carts item : carts){
            if(item.getBookId() == bookId && item.getCustomerId() == customerId){
                item.setQuantity(updatedCart.getQuantity());
                return item;
            }
        }
        return null;
    }
    
    public boolean deleteCart(int customerId, int bookId){
        return carts.removeIf(item -> item.getBookId() == bookId && item.getCustomerId() == customerId);
    }
}
