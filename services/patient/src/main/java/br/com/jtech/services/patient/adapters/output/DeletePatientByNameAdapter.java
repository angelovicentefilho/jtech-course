package br.com.jtech.services.patient.adapters.output;

import br.com.jtech.services.patient.adapters.output.repositories.PatientRepository;
import br.com.jtech.services.patient.application.ports.output.DeletePatientByNameOutputGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeletePatientByNameAdapter implements DeletePatientByNameOutputGateway {

    private final PatientRepository patientRepository;


    @Override
    public void delete(String id) {
        patientRepository.deleteById(UUID.fromString(id));
    }
}
