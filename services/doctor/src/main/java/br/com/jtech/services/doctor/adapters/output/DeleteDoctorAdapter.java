package br.com.jtech.services.doctor.adapters.output;

import br.com.jtech.services.doctor.adapters.output.repositories.DoctorRepository;
import br.com.jtech.services.doctor.application.ports.output.DeleteDoctorOutputGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Adapter for deleting doctor entries.
 * Implements the DeleteDoctorOutputGateway interface.
 */
@Service
@RequiredArgsConstructor
public class DeleteDoctorAdapter implements DeleteDoctorOutputGateway {

    private final DoctorRepository repository;

    /**
     * Deletes a doctor entry by its ID.
     *
     * @param doctorId the ID of the doctor to delete
     */
    @Override
    public void deleteById(String doctorId) {
        this.repository.deleteById(UUID.fromString(doctorId));
    }

    /**
     * Deletes all doctor entries.
     */
    @Override
    public void deleteAll() {
        this.repository.deleteAll();
    }
}