package br.com.jtech.services.doctor.application.core.usecases;

import br.com.jtech.services.doctor.application.core.domains.Doctor;
import br.com.jtech.services.doctor.application.ports.output.FindDoctorByIdOutputGateway;
import br.com.jtech.services.doctor.application.ports.output.UpdateDoctorInputGateway;
import br.com.jtech.services.doctor.application.ports.output.UpdateDoctorOutputGateway;

import static br.com.jtech.services.doctor.application.core.validators.DoctorValidator.isDoctorValid;

/**
 * Use case for updating a doctor.
 * Implements the UpdateDoctorInputGateway interface.
 */
public class UpdateDoctorUseCase implements UpdateDoctorInputGateway {

    private final UpdateDoctorOutputGateway updateDoctorOutputGateway;
    private final FindDoctorByIdOutputGateway findDoctorByIdOutputGateway;

    /**
     * Constructs a new UpdateDoctorUseCase with the specified output gateways.
     *
     * @param updateDoctorOutputGateway   the gateway for updating a doctor
     * @param findDoctorByIdOutputGateway the gateway for finding a doctor by ID
     */
    public UpdateDoctorUseCase(final UpdateDoctorOutputGateway updateDoctorOutputGateway,
                               final FindDoctorByIdOutputGateway findDoctorByIdOutputGateway) {
        this.updateDoctorOutputGateway = updateDoctorOutputGateway;
        this.findDoctorByIdOutputGateway = findDoctorByIdOutputGateway;
    }

    /**
     * Updates an existing doctor.
     *
     * @param doctor the doctor domain object to update
     * @return the updated doctor domain object
     */
    @Override
    public Doctor update(Doctor doctor) {
        isDoctorValid(doctor);
        findDoctorByIdOutputGateway.findByDoctorId(doctor.getId());
        return updateDoctorOutputGateway.update(doctor);
    }
}