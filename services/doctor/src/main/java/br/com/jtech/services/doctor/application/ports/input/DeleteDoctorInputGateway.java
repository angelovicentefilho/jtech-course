package br.com.jtech.services.doctor.application.ports.input;

public interface DeleteDoctorInputGateway {
    void delete(String doctorId);

    void deleteAll();
}
