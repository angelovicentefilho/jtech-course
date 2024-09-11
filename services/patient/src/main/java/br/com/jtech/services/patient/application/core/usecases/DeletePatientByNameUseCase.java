package br.com.jtech.services.patient.application.core.usecases;

import br.com.jtech.services.patient.application.core.validator.PatientValidator;
import br.com.jtech.services.patient.application.ports.input.DeletePatientByNameInputGateway;
import br.com.jtech.services.patient.application.ports.output.DeletePatientByNameOutputGateway;
import br.com.jtech.services.patient.application.ports.output.FindPatientByNameOutputGateway;

public class DeletePatientByNameUseCase implements DeletePatientByNameInputGateway {

    private final DeletePatientByNameOutputGateway deletePatientByNameOutputGateway;
    private final FindPatientByNameOutputGateway findPatientByNameOutputGateway;

    public DeletePatientByNameUseCase(final DeletePatientByNameOutputGateway deletePatientByNameOutputGateway,
                                      final FindPatientByNameOutputGateway findPatientByNameOutputGateway) {
        this.deletePatientByNameOutputGateway = deletePatientByNameOutputGateway;
        this.findPatientByNameOutputGateway = findPatientByNameOutputGateway;
    }

    @Override
    public void delete(String name) {
        PatientValidator.validateName(name);
        var patient = findPatientByNameOutputGateway.findByName(name);
        deletePatientByNameOutputGateway.delete(patient.getId());
    }
}
