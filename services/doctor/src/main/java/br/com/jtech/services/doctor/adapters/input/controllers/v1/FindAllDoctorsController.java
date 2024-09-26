package br.com.jtech.services.doctor.adapters.input.controllers.v1;

import br.com.jtech.services.doctor.adapters.output.protocols.DoctorResponse;
import br.com.jtech.services.doctor.application.ports.output.FindAllDoctorsOutputGateway;
import br.com.jtech.services.doctor.config.infra.annotations.JtechController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import static br.com.jtech.services.doctor.adapters.output.protocols.DoctorResponse.fromDomains;
import static org.springframework.http.ResponseEntity.ok;

/**
 * Controller for finding all doctors.
 */
@RequiredArgsConstructor
@JtechController("/api/v1/doctors")
public class FindAllDoctorsController {

    private final FindAllDoctorsOutputGateway findAllDoctorsOutputGateway;

    /**
     * Finds all doctors.
     *
     * @return a ResponseEntity containing the list of all doctors
     */
    @GetMapping
    public ResponseEntity<DoctorResponse> findAll() {
        return ok(fromDomains(findAllDoctorsOutputGateway.findAll()));
    }

}