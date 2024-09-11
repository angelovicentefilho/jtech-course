package br.com.jtech.services.patient.adapters.output;

import br.com.jtech.services.patient.adapters.output.repositories.PatientRepository;
import br.com.jtech.services.patient.application.core.domains.Patient;
import br.com.jtech.services.patient.application.ports.output.FindPatientByNameOutputGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindPatientByNameAdapter implements FindPatientByNameOutputGateway {

    private final PatientRepository patientRepository;

    @Override
    public Patient findByName(String name) {
        return Patient.fromEntity(patientRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Patient not found")));
    }
}
