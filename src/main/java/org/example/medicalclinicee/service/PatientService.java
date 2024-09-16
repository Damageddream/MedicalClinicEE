package org.example.medicalclinicee.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.medicalclinicee.entity.Patient;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

@ApplicationScoped
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Transactional(Transactional.TxType.REQUIRED)
public class PatientService {
    @PersistenceContext(unitName = "myPU")
    EntityManager entityManager;


    public Collection<Patient> findAll() {
        TypedQuery<Patient> findAll = entityManager.createNamedQuery(Patient.FIND_ALL, Patient.class);
        return Collections.unmodifiableCollection(findAll.getResultList());
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public void create(Patient patient) {
        Objects.requireNonNull(patient);
        entityManager.persist(patient);
    }
}
