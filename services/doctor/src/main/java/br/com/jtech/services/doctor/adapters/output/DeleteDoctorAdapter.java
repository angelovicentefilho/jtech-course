package br.com.jtech.services.doctor.adapters.output;

import br.com.jtech.services.doctor.adapters.output.repositories.DoctorRepository;
import br.com.jtech.services.doctor.application.ports.output.DeleteDoctorOutputGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteDoctorAdapter implements DeleteDoctorOutputGateway {

    private final DoctorRepository repository;

    @Override
    public void deleteById(String doctorId) {
        this.repository.deleteById(UUID.fromString(doctorId));
    }

    @Override
    public void deleteAll() {
        this.repository.deleteAll();
    }
}