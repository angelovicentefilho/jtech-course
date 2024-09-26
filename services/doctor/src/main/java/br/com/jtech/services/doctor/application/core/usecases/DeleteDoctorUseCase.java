package br.com.jtech.services.doctor.application.core.usecases;

import br.com.jtech.services.doctor.application.ports.input.DeleteDoctorInputGateway;
import br.com.jtech.services.doctor.application.ports.output.DeleteDoctorOutputGateway;

import static br.com.jtech.services.doctor.application.core.validators.DoctorValidator.isDoctorIdValid;

/**
 * Use case for deleting a doctor.
 * Implements the DeleteDoctorInputGateway interface.
 */
public class DeleteDoctorUseCase implements DeleteDoctorInputGateway {

    private final DeleteDoctorOutputGateway deleteDoctorOutputGateway;

    /**
     * Constructs a new DeleteDoctorUseCase with the specified output gateway.
     *
     * @param deleteDoctorOutputGateway the gateway for deleting a doctor
     */
    public DeleteDoctorUseCase(DeleteDoctorOutputGateway deleteDoctorOutputGateway) {
        this.deleteDoctorOutputGateway = deleteDoctorOutputGateway;
    }

    /**
     * Deletes a doctor by ID.
     *
     * @param doctorId the ID of the doctor to delete
     */
    @Override
    public void delete(String doctorId) {
        isDoctorIdValid(doctorId);
        deleteDoctorOutputGateway.deleteById(doctorId);
    }

    /**
     * Deletes all doctors.
     */
    @Override
    public void deleteAll() {
        deleteDoctorOutputGateway.deleteAll();
    }
}