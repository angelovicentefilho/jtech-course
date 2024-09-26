package br.com.jtech.services.doctor.adapters.output;

import br.com.jtech.services.doctor.adapters.output.repositories.DoctorRepository;
import br.com.jtech.services.doctor.application.core.domains.Doctor;
import br.com.jtech.services.doctor.application.core.exceptions.DoctorNotFoundException;
import br.com.jtech.services.doctor.application.ports.output.FindDoctorByIdOutputGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static br.com.jtech.services.doctor.application.core.domains.Doctor.fromEntity;

/**
 * Adapter for finding a doctor by ID.
 * Implements the FindDoctorByIdOutputGateway interface.
 */
@Service
@RequiredArgsConstructor
public class FindDoctorByIdAdapter implements FindDoctorByIdOutputGateway {

    private final DoctorRepository repository;

    /**
     * Finds a doctor by their ID.
     *
     * @param id the UUID of the doctor to find
     * @return the found doctor domain object
     * @throws DoctorNotFoundException if no doctor is found with the given ID
     */
    @Override
    public Doctor findByDoctorId(UUID id) {
        return fromEntity(this.repository.findById(id)
                .orElseThrow(() -> new DoctorNotFoundException("Doctor not found!")));
    }
}