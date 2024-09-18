package br.com.jtech.services.doctor.application.ports.output;

public interface DeleteDoctorOutputGateway {
    void deleteById(String doctorId);

    void deleteAll();
}
