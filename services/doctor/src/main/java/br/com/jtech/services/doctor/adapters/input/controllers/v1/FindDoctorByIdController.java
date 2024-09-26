package br.com.jtech.services.doctor.adapters.input.controllers.v1;

import br.com.jtech.services.doctor.adapters.output.protocols.DoctorResponse;
import br.com.jtech.services.doctor.application.ports.output.FindDoctorByIdOutputGateway;
import br.com.jtech.services.doctor.config.infra.annotations.JtechController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

import static br.com.jtech.services.doctor.adapters.output.protocols.DoctorResponse.fromDomain;
import static br.com.jtech.services.doctor.config.infra.utils.Response.okOrNotFound;

/**
 * Controller for finding a doctor by ID.
 */
@RequiredArgsConstructor
@JtechController("/api/v1/doctors")
public class FindDoctorByIdController {

    private final FindDoctorByIdOutputGateway findDoctorByIdOutputGateway;

    /**
     * Finds a doctor by their ID.
     *
     * @param doctorId the ID of the doctor to find
     * @return a ResponseEntity containing the doctor response or a not found status
     */
    @GetMapping("/{doctorId}")
    public ResponseEntity<DoctorResponse> findById(@PathVariable String doctorId) {
        var response = findDoctorByIdOutputGateway.findByDoctorId(UUID.fromString(doctorId));
        return okOrNotFound(fromDomain(response));
    }
}