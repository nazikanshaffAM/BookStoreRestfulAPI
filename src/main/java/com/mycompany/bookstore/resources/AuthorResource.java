/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bookstore.resources;

/**
 *
 * @author Nk
 */
import com.mycompany.bookstore.dao.AuthorDAO;
import com.mycompany.bookstore.exceptions.AuthorNotFoundException;
import com.mycompany.bookstore.model.Authors;
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


@Path("/authors")
@Produces(MediaType.APPLICATION_JSON)

public class AuthorResource {
    
    private final AuthorDAO authorDao;
    
    public AuthorResource(){
        this.authorDao = new AuthorDAO();
    }
    
    public AuthorResource(AuthorDAO authorDao){
        this.authorDao = authorDao;
    }
    
    @GET
    public Response getAllAuthors(){
        
            List<Authors> getAuthors = authorDao.getAllAuthors();
            return Response.ok(getAuthors).build();
        
    }
    
    @POST
    public Response addAuthors(Authors author){
        
            authorDao.addAuthor(author);
            return Response.status(Response.Status.CREATED).build();
        
        
    }
    
    @GET
    @Path("/{id}")
    public Response getAuthorById(@PathParam("id") int id){
       
            Authors author = authorDao.getAuthorById(id);
            if(author != null){
                return Response.ok(author).build();
            }else{
                throw new AuthorNotFoundException(" *ERROR* Author not found ");
            }
        
    }
    
    @PUT
    @Path("/{id}")
    public Response updateAuthor(@PathParam("id") int id, Authors updateAuthor){
       
            updateAuthor.setId(id);
            boolean updated = authorDao.updateAuthor(updateAuthor);
            if(!updated){
                throw new AuthorNotFoundException(" *ERROR* Author with ID: " + id + " not Exist ");
            }
            return Response.ok().build();
    }
    
    @DELETE
    @Path("/{id}")
    public Response deleteAppointment(@PathParam("id") int id){
            boolean deleted = authorDao.deleteAuthorById(id);
            if (deleted) {
                return Response.ok().build(); 
            } else {
                throw new AuthorNotFoundException(" *ERROR* Author with ID: " + id + " not Exist");  
            }   
    }
    
}