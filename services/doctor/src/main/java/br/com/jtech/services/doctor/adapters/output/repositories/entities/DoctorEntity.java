package br.com.jtech.services.doctor.adapters.output.repositories.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.UUID;

/**
 * Entity representing a doctor in the database.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TypeAlias(value = "Doctor")
@Document(collection = "doctors")
public class DoctorEntity implements Serializable {

    /**
     * The unique identifier of the doctor.
     */
    @Id
    private UUID id;

    /**
     * The name of the doctor.
     */
    private String name;

    /**
     * The speciality of the doctor.
     */
    private String speciality;

    /**
     * The email of the doctor.
     */
    private String email;
}