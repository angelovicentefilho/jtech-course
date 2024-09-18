package br.com.jtech.services.doctor.application.ports.output;

import br.com.jtech.services.doctor.application.core.domains.Doctor;

import java.util.List;

public interface FindDoctorBySpecialityOutputGateway {
    List<Doctor> findBySpeciality(String speciality);
}
