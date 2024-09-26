package br.com.jtech.services.doctor.adapters.input.controllers.v1;

import br.com.jtech.services.doctor.application.ports.input.DeleteDoctorInputGateway;
import br.com.jtech.services.doctor.config.infra.annotations.JtechController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Controller for deleting doctor entries.
 */
@RequiredArgsConstructor
@JtechController("/api/v1/doctors")
public class DeleteDoctorController {

    private final DeleteDoctorInputGateway deleteDoctorInputGateway;

    /**
     * Deletes a doctor entry by ID.
     *
     * @param doctorId the ID of the doctor to delete
     * @return a ResponseEntity with no content status
     */
    @DeleteMapping("/{doctorId}")
    public ResponseEntity<Void> delete(@PathVariable String doctorId) {
        deleteDoctorInputGateway.delete(doctorId);
        return ResponseEntity.noContent().build();
    }

    /**
     * Deletes all doctor entries.
     *
     * @return a ResponseEntity with no content status
     */
    @DeleteMapping()
    public ResponseEntity<Void> deleteAll() {
        deleteDoctorInputGateway.deleteAll();
        return ResponseEntity.noContent().build();
    }
}