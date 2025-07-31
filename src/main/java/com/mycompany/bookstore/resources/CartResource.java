/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bookstore.resources;

/**
 *
 * @author Nk
 */


import com.mycompany.bookstore.dao.BookDAO;
import com.mycompany.bookstore.dao.CartDAO;
import com.mycompany.bookstore.dao.CustomerDAO;
import com.mycompany.bookstore.exceptions.BookNotFoundException;
import com.mycompany.bookstore.exceptions.CartNotFoundException;
import com.mycompany.bookstore.exceptions.CustomerNotFoundException;
import com.mycompany.bookstore.model.Carts;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/customers/{customerId}/cart")
@Produces(MediaType.APPLICATION_JSON)


public class CartResource {
    
    private static final CartDAO cartDao = new CartDAO();
    private final CustomerDAO customerDAO = new CustomerDAO();
    private final BookDAO bookDAO = new BookDAO();
    
    @GET
     public Response getCartItems(@PathParam("customerId") int customerId){
        List<Carts> carts = cartDao.getCartItemByCustomerId(customerId);
        if (carts == null || carts.isEmpty()) {
            throw new CustomerNotFoundException(" *ERROR* No cart items found for customer ID: " + customerId);
        }
        return Response.ok(carts).build();
    }
    
    @POST
    @Path("/items")
    public Response addItemToCart(@PathParam("customerId") int customerId, Carts cartItem){
        if(bookDAO.getBookById(cartItem.getBookId()) == null){
            throw new BookNotFoundException(" *ERROR* Book Not Found" + cartItem.getBookId());
                    
        }
        if(customerDAO.getCustomerById(customerId) == null){
            throw new  CustomerNotFoundException(" *ERROR* Customer Not Found" + customerId);
                    
        }
        Carts addedItem = cartDao.addItemToCart(customerId, cartItem);
        return Response.status(Response.Status.CREATED).entity(addedItem).build();
    }
    
    @PUT
    @Path("/items/{bookId}")
    public Response updateCartItem(@PathParam("customerId")int customerId, @PathParam("bookId") int bookId,Carts updateCart){
        Carts updateItem = cartDao.updateCartItem(customerId, bookId, updateCart);
        if(updateItem == null){
            throw new CartNotFoundException(" *ERROR* Cart not found for customer id: " + customerId);
        }
        return Response.ok(updateItem).build();
    }
    
    @DELETE
    @Path("/items/{bookId}")
    public Response deleteCart(@PathParam("customerId")int customerId,@PathParam("bookId")int bookId){
        boolean removed = cartDao.deleteCart(customerId, bookId);
        if(removed){
            return Response.status(Response.Status.NO_CONTENT).build();
            
        }
        throw new CartNotFoundException(" *ERROR* Cart not found for customer id: " + customerId);
    }
   
}







 

