package br.com.jtech.services.patient.adapters.input.controllers;

import br.com.jtech.services.patient.adapters.input.protocols.PatientResponse;
import br.com.jtech.services.patient.application.ports.output.FindPatientByNameOutputGateway;
import br.com.jtech.services.patient.config.infra.annotations.JtechController;
import br.com.jtech.services.patient.config.infra.utils.Response;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static br.com.jtech.services.patient.adapters.input.protocols.PatientResponse.fromDomain;
import static br.com.jtech.services.patient.config.infra.utils.Response.okOrNotFound;


@RequiredArgsConstructor
@JtechController("/api/v1/patients")
public class FindPatientByNameController {

    private final FindPatientByNameOutputGateway findPatientByNameInputGateway;

    @GetMapping
    public ResponseEntity<PatientResponse> findByName(@RequestParam String name) {
        var patient = findPatientByNameInputGateway.findByName(name);
        return okOrNotFound(fromDomain(patient));
    }
}
