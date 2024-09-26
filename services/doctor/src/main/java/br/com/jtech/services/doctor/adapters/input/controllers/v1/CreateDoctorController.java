package br.com.jtech.services.doctor.adapters.input.controllers.v1;

import br.com.jtech.services.doctor.adapters.input.protocols.DoctorRequest;
import br.com.jtech.services.doctor.adapters.output.protocols.DoctorResponse;
import br.com.jtech.services.doctor.application.ports.input.CreateDoctorInputGateway;
import br.com.jtech.services.doctor.config.infra.annotations.JtechController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static br.com.jtech.services.doctor.application.core.domains.Doctor.fromRequest;
import static br.com.jtech.services.doctor.config.infra.utils.Response.createdOrBadRequest;

/**
 * Controller for creating doctor entries.
 */
@RequiredArgsConstructor
@JtechController("/api/v1/doctors")
public class CreateDoctorController {

    private final CreateDoctorInputGateway createDoctorInputGateway;

    /**
     * Creates a new doctor entry.
     *
     * @param request the doctor request containing the details of the doctor to create
     * @return a ResponseEntity with the doctor response containing the details of the created doctor
     */
    @PostMapping
    public ResponseEntity<DoctorResponse> create(@RequestBody DoctorRequest request) {
        var response = createDoctorInputGateway.create(fromRequest(request));
        return createdOrBadRequest("/{id}", DoctorResponse.fromDomain(response), response.getId());
    }
}