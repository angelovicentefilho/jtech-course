package br.com.jtech.services.doctor.adapters.input.controllers;

import br.com.jtech.services.doctor.application.ports.input.DeleteDoctorInputGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/doctors")
@RequiredArgsConstructor
public class DeleteDoctorController {

    private final DeleteDoctorInputGateway deleteDoctorInputGateway;


    @DeleteMapping("/{doctorId}")
    public ResponseEntity<Void> delete(@PathVariable String doctorId) {
        deleteDoctorInputGateway.delete(doctorId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping()
    public ResponseEntity<Void> deleteAll() {
        deleteDoctorInputGateway.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
