package br.com.jtech.services.doctor.application.ports.output;

import br.com.jtech.services.doctor.application.core.domains.Doctor;

import java.util.List;

public interface FindAllDoctorsOutputGateway {
    List<Doctor> findAll();
}
