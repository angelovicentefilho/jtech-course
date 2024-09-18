package br.com.jtech.services.doctor.application.ports.output;

import br.com.jtech.services.doctor.application.core.domains.Doctor;

public interface UpdateDoctorOutputGateway {
    Doctor update(Doctor doctor);
}
