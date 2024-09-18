package br.com.jtech.services.doctor.adapters.input.controllers;

import br.com.jtech.services.doctor.adapters.output.protocols.DoctorResponse;
import br.com.jtech.services.doctor.application.ports.output.FindDoctorBySpecialityOutputGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static br.com.jtech.services.doctor.adapters.output.protocols.DoctorResponse.fromDomains;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1/doctors")
@RequiredArgsConstructor
public class FindDoctorBySpecialityController {

    private final FindDoctorBySpecialityOutputGateway findDoctorBySpecialityOutputGateway;

    @GetMapping("/{speciality}")
    public ResponseEntity<DoctorResponse> findBySpeciality(@PathVariable String speciality) {
        return ok(fromDomains(findDoctorBySpecialityOutputGateway.findBySpeciality(speciality)));
    }
}
