package br.com.jtech.services.doctor.application.core.usecases;

import br.com.jtech.services.doctor.application.ports.input.DeleteDoctorInputGateway;
import br.com.jtech.services.doctor.application.ports.output.DeleteDoctorOutputGateway;

import static br.com.jtech.services.doctor.application.core.validators.DoctorValidator.isDoctorIdValid;

public class DeleteDoctorUseCase implements DeleteDoctorInputGateway {

    private final DeleteDoctorOutputGateway deleteDoctorOutputGateway;

    public DeleteDoctorUseCase(DeleteDoctorOutputGateway deleteDoctorOutputGateway) {
        this.deleteDoctorOutputGateway = deleteDoctorOutputGateway;
    }

    @Override
    public void delete(String doctorId) {
        isDoctorIdValid(doctorId);
        deleteDoctorOutputGateway.deleteById(doctorId);
    }

    @Override
    public void deleteAll() {
        deleteDoctorOutputGateway.deleteAll();
    }
}