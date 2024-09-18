package br.com.jtech.services.patient.application.ports.input;

import br.com.jtech.services.patient.application.core.domains.Patient;

public interface UpdatePatientInputGateway {
    Patient update(Patient patient);
}
