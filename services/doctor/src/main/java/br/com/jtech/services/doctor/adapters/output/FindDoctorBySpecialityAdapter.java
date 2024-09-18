package br.com.jtech.services.doctor.adapters.output;

import br.com.jtech.services.doctor.adapters.output.repositories.DoctorRepository;
import br.com.jtech.services.doctor.application.core.domains.Doctor;
import br.com.jtech.services.doctor.application.ports.output.FindDoctorBySpecialityOutputGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.jtech.services.doctor.application.core.domains.Doctor.fromEntities;

@Service
@RequiredArgsConstructor
public class FindDoctorBySpecialityAdapter implements FindDoctorBySpecialityOutputGateway {

    private final DoctorRepository repository;

    @Override
    public List<Doctor> findBySpeciality(String speciality) {
        return fromEntities(repository.findBySpeciality(speciality));
    }

}