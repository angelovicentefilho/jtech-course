package br.com.jtech.services.doctor.adapters.output;

import br.com.jtech.services.doctor.adapters.output.repositories.DoctorRepository;
import br.com.jtech.services.doctor.application.core.domains.Doctor;
import br.com.jtech.services.doctor.application.ports.output.UpdateDoctorOutputGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Adapter for updating doctor entries.
 * Implements the UpdateDoctorOutputGateway interface.
 */
@Service
@RequiredArgsConstructor
public class UpdateDoctorAdapter implements UpdateDoctorOutputGateway {

    private final DoctorRepository repository;

    /**
     * Updates an existing doctor entry in the repository.
     *
     * @param doctor the doctor domain object to update
     * @return the updated doctor domain object
     */
    @Override
    public Doctor update(Doctor doctor) {
        return Doctor.fromEntity(repository.save(doctor.toEntity()));
    }

}