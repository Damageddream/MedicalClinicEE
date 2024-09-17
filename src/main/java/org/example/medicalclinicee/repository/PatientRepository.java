package org.example.medicalclinicee.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.medicalclinicee.entity.Patient;

import java.util.Collection;
import java.util.Objects;

@ApplicationScoped
public class PatientRepository {

    @PersistenceContext(unitName = "myPU")
    private EntityManager entityManager;

    public Collection<Patient> findAll() {
        return entityManager.createQuery("SELECT p FROM Patient p", Patient.class).getResultList();
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public void create(Patient patient) {
        Objects.requireNonNull(patient);
        entityManager.persist(patient);
    }

    public Patient findPatientById(Long id) {
        return entityManager.find(Patient.class, id);
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public void delete(Long id) {
        Patient patient = entityManager.find(Patient.class, id);
        if (!entityManager.contains(patient)) {
            patient = entityManager.merge(patient);
        }
        entityManager.remove(patient);
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public void update(Patient patient) {
        entityManager.merge(patient);
    }


}
