package br.com.jtech.services.patient.application.ports.output;

import br.com.jtech.services.patient.application.core.domains.Patient;

public interface FindPatientByIdOutputGateway {
    Patient findById(String id);
}
