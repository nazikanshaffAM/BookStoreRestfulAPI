/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bookstore.resources;

/**
 *
 * @author Nk
 */

import com.mycompany.bookstore.dao.CustomerDAO;
import com.mycompany.bookstore.dao.OrderDAO;
import com.mycompany.bookstore.exceptions.CustomerNotFoundException;
import com.mycompany.bookstore.model.Orders;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/customers/{customerId}/orders")
@Produces(MediaType.APPLICATION_JSON)

public class OrderResource {
     private final OrderDAO orderDao = new OrderDAO();
     private final CustomerDAO customerdao = new CustomerDAO();

    
     @POST
    public Response createOrder(@PathParam("customerId") int customerId, Orders order) {
        if(customerdao.getCustomerById(customerId) == null){
            throw new CustomerNotFoundException(" *ERROR* Error customer not found by id " + customerId);
        }
        Orders newOrder = orderDao.createOrder(customerId, order.getCarts());
        return Response.status(Response.Status.CREATED).entity(newOrder).build();
    }
     
    @GET
    public Response getOrders(@PathParam("customerId")int customerId){
        List<Orders> orders = orderDao.getOrderByCustomerId(customerId);
        return Response.ok(orders).build();
    }
    
    @GET
    @Path("/{orderId}")
    public Response getOrderById(@PathParam("customerId")int customerId,@PathParam("orderId")int orderId){
        Orders order = orderDao.getOrderByCustomerIdAndOrderId(customerId, orderId);
        if(order == null){
            return Response.status(Response.Status.NOT_FOUND).entity(" *ERROR* Order not found...").build();
        }
        return Response.ok(order).build();
        
    } 
    
}
