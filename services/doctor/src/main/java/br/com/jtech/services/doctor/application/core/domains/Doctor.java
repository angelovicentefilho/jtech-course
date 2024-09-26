package br.com.jtech.services.doctor.application.core.domains;

import br.com.jtech.services.doctor.adapters.input.protocols.DoctorRequest;
import br.com.jtech.services.doctor.adapters.output.repositories.entities.DoctorEntity;
import lombok.*;
import br.com.jtech.services.doctor.config.infra.utils.GenId;

import java.util.UUID;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {

    private UUID id;
    private String name;
    private String speciality;
    private String email;

    /**
     * Converts a list of DoctorEntity objects to a list of Doctor domain objects.
     *
     * @param entities the list of DoctorEntity objects to convert
     * @return a list of Doctor domain objects
     */
    public static List<Doctor> fromEntities(List<DoctorEntity> entities) {
        return entities.stream().map(Doctor::fromEntity).toList();
    }

    /**
     * Converts this Doctor domain object to a DoctorEntity object.
     *
     * @return the converted DoctorEntity object
     */
    public DoctorEntity toEntity() {
        return DoctorEntity.builder()
                .id(getId())
                .name(getName())
                .speciality(getSpeciality())
                .email(getEmail())
                .build();
    }

    /**
     * Converts a DoctorEntity object to a Doctor domain object.
     *
     * @param document the DoctorEntity object to convert
     * @return the converted Doctor domain object
     */
    public static Doctor fromEntity(DoctorEntity document) {
        return Doctor.builder()
                .id(document.getId())
                .name(document.getName())
                .speciality(document.getSpeciality())
                .email(document.getEmail())
                .build();
    }

    /**
     * Converts a DoctorRequest object to a Doctor domain object.
     *
     * @param request the DoctorRequest object to convert
     * @return the converted Doctor domain object
     */
    public static Doctor fromRequest(DoctorRequest request) {
        return Doctor.builder()
                .id(GenId.newUuid(request.getId()))
                .name(request.getName())
                .speciality(request.getSpeciality())
                .email(request.getEmail())
                .build();
    }
}