import org.example.medicalclinicee.entity.Patient;
import org.example.medicalclinicee.repository.PatientRepository;
import org.example.medicalclinicee.service.PatientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class PatientServiceTest {
    @InjectMocks
    private PatientService patientService;

    @Mock
    private PatientRepository patientRepository;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreatePatient(){
        Patient patient = new Patient();
        patient.setId(1L);
        patient.setEmail("mail");
        patient.setPassword("password");
        patient.setFirstName("Mar");
        patient.setLastName("Gra");
        patient.setIdCardNo("23");

        patientService.createPatient(patient);

        verify(patientRepository, times(1)).create(patient);
    }
    @Test
    public void testGetPatientById_PatientExists() {
        // Arrange
        Long patientId = 1L;
        Patient patient = new Patient();
        patient.setId(patientId);

        when(patientRepository.findPatientById(patientId)).thenReturn(patient);

        // Act
        Patient result = patientService.getPatientById(patientId);

        // Assert
        assertNotNull(result);
        assertEquals(patientId, result.getId());
        verify(patientRepository, times(1)).findPatientById(patientId);
    }


}
