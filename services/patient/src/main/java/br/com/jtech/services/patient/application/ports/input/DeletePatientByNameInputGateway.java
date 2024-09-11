package br.com.jtech.services.patient.application.ports.input;

public interface DeletePatientByNameInputGateway {
    void delete(String name);
}
