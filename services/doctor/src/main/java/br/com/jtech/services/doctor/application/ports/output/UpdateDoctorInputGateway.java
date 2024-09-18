package br.com.jtech.services.doctor.application.ports.output;

import br.com.jtech.services.doctor.application.core.domains.Doctor;

public interface UpdateDoctorInputGateway {
    Doctor update(Doctor doctor);
}
