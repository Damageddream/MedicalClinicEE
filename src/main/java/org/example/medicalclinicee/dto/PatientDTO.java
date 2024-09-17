package org.example.medicalclinicee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO {
    private  String email;
    private  String firstName;
    private  String lastName;
    private  String phoneNumber;
    private  LocalDate birthday;
}
