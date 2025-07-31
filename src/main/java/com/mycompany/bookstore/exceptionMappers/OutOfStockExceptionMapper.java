/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bookstore.exceptionMappers;

/**
 *
 * @author Nk
 */

import com.mycompany.bookstore.exceptions.OutOfStockException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class OutOfStockExceptionMapper implements ExceptionMapper<OutOfStockException> {

    @Override
    public Response toResponse(OutOfStockException e) {
        return Response.status(Response.Status.CONFLICT)
                .entity("{\"error\": \"Out of stock\", \"message\": \"" + e.getMessage() + "\"}")
                .type(MediaType.APPLICATION_JSON).build();
    }
}
