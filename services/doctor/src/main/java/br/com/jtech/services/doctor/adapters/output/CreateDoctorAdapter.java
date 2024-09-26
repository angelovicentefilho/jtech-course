package br.com.jtech.services.doctor.adapters.output;

import br.com.jtech.services.doctor.adapters.output.repositories.DoctorRepository;
import br.com.jtech.services.doctor.application.core.domains.Doctor;
import br.com.jtech.services.doctor.application.ports.output.CreateDoctorOutputGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Adapter for creating doctor entries.
 * Implements the CreateDoctorOutputGateway interface.
 */
@Component
@RequiredArgsConstructor
public class CreateDoctorAdapter implements CreateDoctorOutputGateway {

    private final DoctorRepository repository;

    /**
     * Creates a new doctor entry in the repository.
     *
     * @param doctor the doctor domain object to create
     * @return the created doctor domain object
     */
    @Override
    public Doctor create(Doctor doctor) {
        return Doctor.fromEntity(this.repository.save(doctor.toEntity()));
    }

}