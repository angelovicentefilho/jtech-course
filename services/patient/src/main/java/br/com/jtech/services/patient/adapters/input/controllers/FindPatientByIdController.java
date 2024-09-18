package br.com.jtech.services.patient.adapters.input.controllers;

import br.com.jtech.services.patient.adapters.input.protocols.PatientResponse;
import br.com.jtech.services.patient.application.ports.output.FindPatientByIdOutputGateway;
import br.com.jtech.services.patient.application.ports.output.FindPatientByNameOutputGateway;
import br.com.jtech.services.patient.config.infra.annotations.JtechController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static br.com.jtech.services.patient.adapters.input.protocols.PatientResponse.fromDomain;
import static br.com.jtech.services.patient.config.infra.utils.Response.okOrNotFound;


@RequiredArgsConstructor
@JtechController("/api/v1/patients")
public class FindPatientByIdController {

    private final FindPatientByIdOutputGateway findPatientByIdOutputGateway;

    @GetMapping
    public ResponseEntity<PatientResponse> findByName(@RequestParam String id) {
        var patient = findPatientByIdOutputGateway.findById(id);
        return okOrNotFound(fromDomain(patient));
    }
}
