package org.example.medicalclinicee.rest;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.medicalclinicee.dto.PatientDTO;
import org.example.medicalclinicee.dto.mapper.PatientMapper;
import org.example.medicalclinicee.entity.Patient;
import org.example.medicalclinicee.service.PatientService;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Path("/patient")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PatientResource {
    @Inject
    PatientService patientService;

    @Inject
    PatientMapper patientMapper;

    @GET
    public Response patients() {
        Collection<Patient> patients = patientService.findAll();
        List<PatientDTO> patientsDTO = patients.stream().map(patientMapper::toDTO).collect(Collectors.toList());
        return Response.ok(patientsDTO).build();
    }

    @POST
    public Response create(PatientDTO patient) {

        patientService.createPatient(patientMapper.fromDto(patient));
        return Response.ok().build();
    }

    @GET
    @Path("/{id}")
    public Response getPatient(@PathParam("id") Long id) {
        Patient patient = patientService.getPatientById(id);
        return Response.ok(patientMapper.toDTO(patient)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletePatient(@PathParam("id") Long id) {
        patientService.delete(id);
        return Response.ok().build();
    }

    @PUT
    @Path("/{id}")
    public Response updatePatient(@PathParam("id") Long id, PatientDTO patientDTO) {
        Patient patient = patientMapper.fromDto(patientDTO);
        patient.setId(id);
        patientService.update(patient);
        return Response.ok().build();
    }

}
