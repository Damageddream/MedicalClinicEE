package org.example.medicalclinicee.dto.mapper;

import org.example.medicalclinicee.dto.PatientDTO;
import org.example.medicalclinicee.entity.Patient;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface PatientMapper {
    PatientDTO toDTO(Patient patient);
    Patient fromDto(PatientDTO newPatientDTO);

}
