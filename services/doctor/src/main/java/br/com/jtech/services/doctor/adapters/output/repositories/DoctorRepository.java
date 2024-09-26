package br.com.jtech.services.doctor.adapters.output.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import br.com.jtech.services.doctor.adapters.output.repositories.entities.DoctorEntity;

import java.util.List;
import java.util.UUID;

/**
 * Repository interface for Doctor entities.
 * Extends MongoRepository to provide CRUD operations for DoctorEntity.
 */
@Repository
public interface DoctorRepository extends MongoRepository<DoctorEntity, UUID> {

}