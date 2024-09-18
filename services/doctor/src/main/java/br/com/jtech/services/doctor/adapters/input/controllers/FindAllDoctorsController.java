package br.com.jtech.services.doctor.adapters.input.controllers;

import br.com.jtech.services.doctor.adapters.output.protocols.DoctorResponse;
import br.com.jtech.services.doctor.application.ports.output.FindAllDoctorsOutputGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static br.com.jtech.services.doctor.adapters.output.protocols.DoctorResponse.fromDomains;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1/doctors")
@RequiredArgsConstructor
public class FindAllDoctorsController {

    private final FindAllDoctorsOutputGateway findAllDoctorsOutputGateway;

    @GetMapping
    public ResponseEntity<DoctorResponse> findAll() {
        return ok(fromDomains(findAllDoctorsOutputGateway.findAll()));
    }

}
