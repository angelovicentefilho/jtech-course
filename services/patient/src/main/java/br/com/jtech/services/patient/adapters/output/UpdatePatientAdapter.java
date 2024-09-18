package br.com.jtech.services.patient.adapters.output;

import br.com.jtech.services.patient.adapters.output.repositories.PatientRepository;
import br.com.jtech.services.patient.application.core.domains.Patient;
import br.com.jtech.services.patient.application.ports.output.UpdatePatientOutputGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdatePatientAdapter implements UpdatePatientOutputGateway {

    private final PatientRepository patientRepository;

    @Override
    public Patient update(Patient patient) {
        return Patient.fromEntity(patientRepository.save(patient.toEntity()));
    }
}
