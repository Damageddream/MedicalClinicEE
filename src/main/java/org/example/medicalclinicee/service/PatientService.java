package org.example.medicalclinicee.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.medicalclinicee.entity.Patient;
import org.example.medicalclinicee.exception.PatientNotFoundException;
import org.example.medicalclinicee.repository.PatientRepository;

import java.util.Collection;


@ApplicationScoped
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class PatientService {
    @Inject
    PatientRepository patientRepository;

    public void createPatient(Patient patient) {
        patientRepository.create(patient);
    }

    public Patient getPatientById(Long id) {
        Patient patient = patientRepository.findPatientById(id);
        if(patient == null){
            throw new PatientNotFoundException("Patient with id: "+id+" not found");
        }
        return patient;
    }

    public Collection<Patient> findAll() {
        return patientRepository.findAll();
    }

    public void delete(Long id) {
        patientRepository.delete(id);
    }

    public void update(Patient patient) {
        patientRepository.update(patient);
    }


}
