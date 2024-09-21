package org.example.medicalclinicee.service;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.example.medicalclinicee.exception.PatientNotFoundException;

@Provider
public class RuntimeExceptionMapper implements ExceptionMapper<RuntimeException> {
    @Override
    public Response toResponse(RuntimeException exception) {
        if (exception instanceof PatientNotFoundException) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Entity not found: " + exception.getMessage())
                    .build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("An unexpected error occured: " + exception.getMessage())
                    .build();
        }
    }
}
