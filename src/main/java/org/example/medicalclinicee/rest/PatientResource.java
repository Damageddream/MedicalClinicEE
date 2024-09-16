package org.example.medicalclinicee.rest;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.medicalclinicee.entity.Patient;
import org.example.medicalclinicee.service.PatientService;

@Path("/patient")
@RequestScoped
public class PatientResource {
    @Inject
    PatientService patientService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response patients() {
        return Response.ok(patientService.findAll()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Patient patient) {
        patientService.create(patient);
        return Response.ok().build();
    }
}
