package br.com.jtech.services.doctor.application.core.usecases;

import br.com.jtech.services.doctor.application.core.domains.Doctor;
import br.com.jtech.services.doctor.application.core.exceptions.DoctorDuplicateException;
import br.com.jtech.services.doctor.application.core.exceptions.DoctorNotFoundException;
import br.com.jtech.services.doctor.application.ports.input.CreateDoctorInputGateway;
import br.com.jtech.services.doctor.application.ports.output.CreateDoctorOutputGateway;
import br.com.jtech.services.doctor.application.ports.output.FindDoctorByIdOutputGateway;

import static br.com.jtech.services.doctor.application.core.validators.DoctorValidator.isDoctorValid;
import static java.util.Objects.nonNull;

/**
 * Use case for creating a doctor.
 * Implements the CreateDoctorInputGateway interface.
 */
public class CreateDoctorUseCase implements CreateDoctorInputGateway {

    private final CreateDoctorOutputGateway createDoctorOutputGateway;
    private final FindDoctorByIdOutputGateway findDoctorByIdOutputGateway;

    /**
     * Constructs a new CreateDoctorUseCase with the specified output gateways.
     *
     * @param createDoctorOutputGateway   the gateway for creating a doctor
     * @param findDoctorByIdOutputGateway the gateway for finding a doctor by ID
     */
    public CreateDoctorUseCase(final CreateDoctorOutputGateway createDoctorOutputGateway,
                               final FindDoctorByIdOutputGateway findDoctorByIdOutputGateway) {
        this.createDoctorOutputGateway = createDoctorOutputGateway;
        this.findDoctorByIdOutputGateway = findDoctorByIdOutputGateway;
    }

    /**
     * Creates a new doctor.
     *
     * @param doctor the doctor domain object to create
     * @return the created doctor domain object
     * @throws DoctorDuplicateException if a doctor with the same ID already exists
     * @throws DoctorNotFoundException  if the doctor is not found
     */
    public Doctor create(Doctor doctor) {
        isDoctorValid(doctor);
        try {
            var other = findDoctorByIdOutputGateway.findByDoctorId(doctor.getId());
            if (nonNull(other)) {
                throw new DoctorDuplicateException("Doctor already exists!");
            }
        } catch (DoctorNotFoundException exception) {
            return createDoctorOutputGateway.create(doctor);
        }
        throw new DoctorNotFoundException("Doctor not found");
    }
}