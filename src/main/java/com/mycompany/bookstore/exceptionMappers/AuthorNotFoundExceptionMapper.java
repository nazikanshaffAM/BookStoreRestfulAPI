/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bookstore.exceptionMappers;

/**
 *
 * @author Nk
 */
import com.mycompany.bookstore.exceptions.AuthorNotFoundException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class AuthorNotFoundExceptionMapper implements ExceptionMapper<AuthorNotFoundException> {

    @Override
    public Response toResponse(AuthorNotFoundException e) {
        return Response.status(Response.Status.NOT_FOUND)
                .entity("{\"error\": \"Author not found\", \"message\": \""
                        + e.getMessage() + "\"}")
                .type(MediaType.APPLICATION_JSON).build();
    }
}
