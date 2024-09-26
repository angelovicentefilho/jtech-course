package br.com.jtech.services.doctor.adapters.output;

import br.com.jtech.services.doctor.adapters.output.repositories.DoctorRepository;
import br.com.jtech.services.doctor.application.core.domains.Doctor;
import br.com.jtech.services.doctor.application.ports.output.FindAllDoctorsOutputGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.jtech.services.doctor.application.core.domains.Doctor.fromEntities;

/**
 * Adapter for finding all doctor entries.
 * Implements the FindAllDoctorsOutputGateway interface.
 */
@Service
@RequiredArgsConstructor
public class FindAllDoctorsAdapter implements FindAllDoctorsOutputGateway {

    private final DoctorRepository repository;

    /**
     * Finds all doctor entries in the repository.
     *
     * @return a list of all doctor domain objects
     */
    @Override
    public List<Doctor> findAll() {
        return fromEntities(this.repository.findAll());
    }
}