package br.com.jtech.services.doctor.application.core.usecases;

import br.com.jtech.services.doctor.application.core.domains.Doctor;
import br.com.jtech.services.doctor.application.ports.output.UpdateDoctorInputGateway;
import br.com.jtech.services.doctor.application.ports.output.UpdateDoctorOutputGateway;

import static br.com.jtech.services.doctor.application.core.validators.DoctorValidator.isDoctorValid;

public class UpdateDoctorUseCase implements UpdateDoctorInputGateway {

    private final UpdateDoctorOutputGateway updateDoctorOutputGateway;

    public UpdateDoctorUseCase(UpdateDoctorOutputGateway updateDoctorOutputGateway) {
        this.updateDoctorOutputGateway = updateDoctorOutputGateway;
    }

    @Override
    public Doctor update(Doctor doctor) {
        isDoctorValid(doctor);
        return updateDoctorOutputGateway.update(doctor);
    }
}