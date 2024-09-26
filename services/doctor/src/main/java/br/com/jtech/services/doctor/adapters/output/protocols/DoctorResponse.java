package br.com.jtech.services.doctor.adapters.output.protocols;

import br.com.jtech.services.doctor.application.core.domains.Doctor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DoctorResponse implements Serializable {
    private String id;
    private String name;
    private String speciality;
    private String email;

    private List<DoctorResponse> responses;

    /**
     * Converts a Doctor domain object to a DoctorResponse.
     *
     * @param doctor the Doctor domain object
     * @return the corresponding DoctorResponse
     */
    public static DoctorResponse fromDomain(Doctor doctor) {
        return DoctorResponse.builder()
                .id(doctor.getId().toString())
                .name(doctor.getName())
                .speciality(doctor.getSpeciality())
                .email(doctor.getEmail())
                .build();
    }

    /**
     * Converts a list of Doctor domain objects to a DoctorResponse containing a list of DoctorResponses.
     *
     * @param doctors the list of Doctor domain objects
     * @return the corresponding DoctorResponse containing a list of DoctorResponses
     */
    public static DoctorResponse fromDomains(List<Doctor> doctors) {
        var list = doctors.stream().map(DoctorResponse::fromDomain).toList();
        return DoctorResponse.builder()
                .responses(list)
                .build();
    }
}