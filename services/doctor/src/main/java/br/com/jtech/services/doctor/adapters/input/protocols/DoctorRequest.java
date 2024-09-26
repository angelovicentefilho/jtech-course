package br.com.jtech.services.doctor.adapters.input.protocols;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * Represents a request to create or update a doctor entry.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DoctorRequest implements Serializable {
    private String id;

    /**
     * The name of the doctor.
     * Cannot be null or blank.
     */
    @NotBlank(message = "Name cannot be null!")
    private String name;

    /**
     * The speciality of the doctor.
     * Cannot be null or blank.
     */
    @NotBlank(message = "Speciality cannot be null!")
    private String speciality;

    /**
     * The email of the doctor.
     * Must be a valid email format and cannot be null or blank.
     */
    @NotBlank(message = "Email cannot be null!")
    @Email(message = "Invalid email!")
    private String email;

    /**
     * A list of additional doctor requests.
     */
    private List<DoctorRequest> requests;
}