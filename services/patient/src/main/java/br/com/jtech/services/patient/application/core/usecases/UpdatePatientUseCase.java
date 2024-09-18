package br.com.jtech.services.patient.application.core.usecases;

import br.com.jtech.services.patient.application.core.domains.Patient;
import br.com.jtech.services.patient.application.ports.input.UpdatePatientInputGateway;
import br.com.jtech.services.patient.application.ports.output.FindPatientByIdOutputGateway;
import br.com.jtech.services.patient.application.ports.output.UpdatePatientOutputGateway;

import static br.com.jtech.services.patient.application.core.validator.PatientValidator.validateForUpdate;

public class UpdatePatientUseCase implements UpdatePatientInputGateway {

    private final FindPatientByIdOutputGateway findPatientByIdOutputGateway;
    private final UpdatePatientOutputGateway updatePatientOutputGateway;

    public UpdatePatientUseCase(final FindPatientByIdOutputGateway findPatientByIdOutputGateway,
                                final UpdatePatientOutputGateway updatePatientOutputGateway) {
        this.findPatientByIdOutputGateway = findPatientByIdOutputGateway;
        this.updatePatientOutputGateway = updatePatientOutputGateway;
    }

    @Override
    public Patient update(Patient patient) {
        validateForUpdate(patient);
        findPatientByIdOutputGateway.findById(patient.getId());
        return updatePatientOutputGateway.update(patient);
    }

}
