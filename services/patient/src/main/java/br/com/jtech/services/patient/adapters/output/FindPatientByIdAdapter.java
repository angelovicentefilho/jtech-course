package br.com.jtech.services.patient.adapters.output;

import br.com.jtech.services.patient.adapters.output.repositories.PatientRepository;
import br.com.jtech.services.patient.application.core.domains.Patient;
import br.com.jtech.services.patient.application.core.exceptions.PatientNotFoundException;
import br.com.jtech.services.patient.application.ports.output.FindPatientByIdOutputGateway;
import br.com.jtech.services.patient.application.ports.output.FindPatientByNameOutputGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FindPatientByIdAdapter implements FindPatientByIdOutputGateway {

    private final PatientRepository patientRepository;

    @Override
    public Patient findById(String id) {
        return Patient.fromEntity(patientRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new PatientNotFoundException("Patient not found")));
    }
}
