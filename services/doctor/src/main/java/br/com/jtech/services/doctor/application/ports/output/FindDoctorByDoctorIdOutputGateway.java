package br.com.jtech.services.doctor.application.ports.output;

import br.com.jtech.services.doctor.application.core.domains.Doctor;

import java.util.UUID;

public interface FindDoctorByDoctorIdOutputGateway {
    Doctor findByDoctorId(UUID id);
}
