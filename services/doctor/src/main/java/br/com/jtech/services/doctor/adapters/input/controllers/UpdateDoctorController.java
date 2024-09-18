package br.com.jtech.services.doctor.adapters.input.controllers;

import br.com.jtech.services.doctor.adapters.input.protocols.DoctorRequest;
import br.com.jtech.services.doctor.adapters.output.protocols.DoctorResponse;
import br.com.jtech.services.doctor.application.ports.output.UpdateDoctorInputGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static br.com.jtech.services.doctor.adapters.output.protocols.DoctorResponse.fromDomain;
import static br.com.jtech.services.doctor.application.core.domains.Doctor.fromRequest;

@RestController
@RequestMapping("/api/v1/doctors")
@RequiredArgsConstructor
public class UpdateDoctorController {

    public final UpdateDoctorInputGateway updateDoctorInputGateway;

    @PutMapping("/{doctorId}")
    public ResponseEntity<DoctorResponse> update(@RequestBody DoctorRequest request, @PathVariable String doctorId) {
        request.setId(doctorId);
        return ResponseEntity.ok(fromDomain(updateDoctorInputGateway.update(fromRequest(request))));
    }

}
