package br.com.jtech.services.doctor.application.ports.output;

import br.com.jtech.services.doctor.application.core.domains.Doctor;

import java.util.UUID;

public interface FindDoctorByIdOutputGateway {
    Doctor findByDoctorId(UUID id);
}
