package br.com.jtech.services.doctor.adapters.output;

import br.com.jtech.services.doctor.adapters.output.repositories.DoctorRepository;
import br.com.jtech.services.doctor.application.core.domains.Doctor;
import br.com.jtech.services.doctor.application.core.exceptions.DoctorNotFoundException;
import br.com.jtech.services.doctor.application.ports.output.FindDoctorByDoctorIdOutputGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static br.com.jtech.services.doctor.application.core.domains.Doctor.fromEntity;

@Service
@RequiredArgsConstructor
public class FindDoctorByDoctorIdAdapter implements FindDoctorByDoctorIdOutputGateway {

    private final DoctorRepository repository;

    @Override
    public Doctor findByDoctorId(UUID id) {
        return fromEntity(this.repository.findById(id)
                .orElseThrow(() -> new DoctorNotFoundException("Doctor not found!")));
    }
}