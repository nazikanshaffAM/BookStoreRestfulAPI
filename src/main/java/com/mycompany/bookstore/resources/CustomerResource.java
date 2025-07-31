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
import com.mycompany.bookstore.exceptions.CustomerNotFoundException;
import com.mycompany.bookstore.model.Customers;
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


@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)

public class CustomerResource {
    private final CustomerDAO customerDao;
    
    public CustomerResource(){
        this.customerDao = new CustomerDAO();
    }
    
    public CustomerResource(CustomerDAO customerDao){
        this.customerDao = customerDao;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCustomers(){
        
            List<Customers> getCustomers = customerDao.getAllCustomer();
            return Response.ok(getCustomers).build();
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response addCustomers(Customers customer){
            customerDao.addCustomer(customer);
            return Response.status(Response.Status.CREATED).build();
    }
    
    @GET
    @Path("/{id}")
    public Response getCustomerById(@PathParam("id") int id){
             Customers customer = customerDao.getCustomerById(id);
            if(customer != null){
                return Response.ok(customer).build();
            }else{
                throw new CustomerNotFoundException(" *ERROR* Customer with ID: " + id + " not Exist"); 
            }
    }
    
    @PUT
    @Path("/{id}")
    public Response updateCustomer(@PathParam("id") int id, Customers updateCustomer){
        
            updateCustomer.setId(id);
            boolean updated = customerDao.updateCustomer(updateCustomer);
            if(!updated){
                throw new CustomerNotFoundException(" *ERROR* Customer with ID: " + id + " not Exist");
            }
            return Response.ok().build();
    }
    
    @DELETE
    @Path("/{id}")
    public Response deleteAppointment(@PathParam("id") int id){
       
            boolean deleted = customerDao.deleteCustomerById(id);
            if(!deleted){
                throw new CustomerNotFoundException("*ERROR* Customer with ID: " + id + " not Exist");
            }
            return Response.ok().build();
    }
    
}
