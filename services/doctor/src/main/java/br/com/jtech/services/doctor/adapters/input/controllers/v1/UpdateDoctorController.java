package br.com.jtech.services.doctor.adapters.input.controllers.v1;

import br.com.jtech.services.doctor.adapters.input.protocols.DoctorRequest;
import br.com.jtech.services.doctor.adapters.output.protocols.DoctorResponse;
import br.com.jtech.services.doctor.application.ports.output.UpdateDoctorInputGateway;
import br.com.jtech.services.doctor.config.infra.annotations.JtechController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static br.com.jtech.services.doctor.adapters.output.protocols.DoctorResponse.fromDomain;
import static br.com.jtech.services.doctor.application.core.domains.Doctor.fromRequest;
import static br.com.jtech.services.doctor.config.infra.utils.Response.okOrNotFound;

/**
 * Controller for updating doctor entries.
 */
@RequiredArgsConstructor
@JtechController("/api/v1/doctors")
public class UpdateDoctorController {

    public final UpdateDoctorInputGateway updateDoctorInputGateway;

    /**
     * Updates an existing doctor entry.
     *
     * @param request  the doctor request containing the updated details
     * @param doctorId the ID of the doctor to update
     * @return a ResponseEntity containing the updated doctor response or a not found status
     */
    @PutMapping("/{doctorId}")
    public ResponseEntity<DoctorResponse> update(@RequestBody DoctorRequest request, @PathVariable String doctorId) {
        request.setId(doctorId);
        return okOrNotFound(fromDomain(updateDoctorInputGateway.update(fromRequest(request))));
    }

}